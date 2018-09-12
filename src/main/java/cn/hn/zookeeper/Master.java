package cn.hn.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Random;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-6 下午2:48
 **/
public class Master implements Watcher {

    private static boolean isLeader  = false;
    ZooKeeper zk;
    String hostPort;
    Random random = new Random();

    Master(String port){
        this.hostPort = port;
    }

    public void zkStart () throws IOException {
        zk = new ZooKeeper(hostPort,150000,this);
    }

    public void zkStop() throws InterruptedException {
        zk.close();
    }


    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    String serverId = Integer.toString(random.nextInt());
//    boolean isLeader = false;
    // returns true if there is a master
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


    public static void main(String[] args) throws Exception {
        Master m = new Master("localhost:2181");
        m.zkStart();
        Thread.sleep(6000);
        m.runForMaster();
        if (isLeader) {
            System.out.println("I'm the leader"); // wait for a bit
            Thread.sleep(600000);
        } else {
            System.out.println("Someone else is the leader");
        }
        m.zkStop();

    }
}
