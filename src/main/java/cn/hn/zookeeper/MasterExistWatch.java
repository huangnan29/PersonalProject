package cn.hn.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.AsyncCallback.StringCallback;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;

import static org.apache.zookeeper.AsyncCallback.*;
import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-11 上午8:03
 **/
public class MasterExistWatch {

    private static final Logger LOG = LoggerFactory.getLogger(Worker.class);
    ZooKeeper zk;
    String hostPort;
    private static boolean isLeader  = false;
    private Random random;
    String serverId = Integer.toString(random.nextInt());

    enum MasterStates {RUNNING, ELECTED, NOTELECTED};
    private volatile MasterStates state = MasterStates.RUNNING;


    StringCallback masterCreateCallback = new StringCallback() {
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (KeeperException.Code.get(rc)) {
                case CONNECTIONLOSS:
                    try {
                        checkMaster();
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case OK:
                    state = MasterStates.ELECTED;
                    takeLeadership();
                    break;
                case NODEEXISTS:
                    state = MasterStates.NOTELECTED;
                    masterExists();
                    break;
                default:
                    state = MasterStates.NOTELECTED;
                    LOG.error("Something went wrong when running for master.",
                            KeeperException.create(KeeperException.Code.get(rc), path));
            }
        }
    };

    private void takeLeadership() {
        System.out.println("this is leader!");

    }

    StatCallback masterExistsCallback = new StatCallback() {public void processResult(int rc, String path, Object ctx, Stat stat) {
            switch (KeeperException.Code.get(rc)) {
                case CONNECTIONLOSS:
                    masterExists();
                    break;
                case OK:
                    if(stat == null) {
                        state = MasterStates.RUNNING;
                        try {
                            runForMaster();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (KeeperException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    try {
                        checkMaster();
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };
    boolean checkMaster() throws KeeperException, InterruptedException {
        /**
         * 同步方法使用while进行异常处理
         */
        while (true) {
            try {
                Stat stat = new Stat();
                byte data[] = zk.getData("/master", false, stat);
                System.out.println(data);
                isLeader = new String(data).equals(serverId);
                return true;
            } catch (KeeperException.NoNodeException e) {
                // no master, so try create again
                return false;
            } catch (KeeperException.ConnectionLossException e) {
            }
        }
    }
    void runForMaster() throws InterruptedException, KeeperException {
        while (true) {
            try {
                zk.create("/master", serverId.getBytes(),
                        OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                isLeader = true;
                break;
            } catch (KeeperException.NodeExistsException e) {
                isLeader = false;
                break;
            } catch (KeeperException.ConnectionLossException e) {
            }
            if (checkMaster()) break;
        }
    }
    void masterExists() {
        zk.exists("/master",
                masterExistsWatcher,
                masterExistsCallback,
                null);
    }
    Watcher masterExistsWatcher = new Watcher() {
        public void process(WatchedEvent e) {
            if(e.getType() == Event.EventType.NodeDeleted) {
                assert "/master".equals( e.getPath() );
                try {
                    runForMaster();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } catch (KeeperException e1) {
                    e1.printStackTrace();
                }
            }
        }
    };
}
