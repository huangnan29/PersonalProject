package cn.hn.zookeeper;

import org.apache.log4j.Logger;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.LoggerFactory;
import org.I0Itec.zkclient.ZkClient;
import java.util.Random;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-7 上午9:16
 **/
public class AsynMaster {
    ZkClient zkClient =new ZkClient("127.0.0.1:2181",5000);
    Random random = new Random();
    String serverId = Integer.toHexString(random.nextInt());
//    static Logger logger = (Logger) LoggerFactory.getLogger(AsynMaster.class);
    final static String MASTER_PATH = "/master";
    boolean isLeader = false;

    public static void main(String[] args) throws InterruptedException {
        AsynMaster master = new AsynMaster();
        master.runForMaster();
        Thread.sleep(60000);
    }

    /**
     * 执行群首选举操作
     *
     * @return
     */
    void runForMaster() {
//        logger.info("try election leader .");
        AsyncCallback.StringCallback sc = new AsyncCallback.StringCallback() {
            public void processResult(int rc, String path, Object ctx, String name) {
                switch (KeeperException.Code.get(rc)) {
                    case CONNECTIONLOSS:
                        checkExistsMaster();
                        return;
                    case OK:
                        isLeader = true;
                        break;
                    default:
                        isLeader = false;
                }
//                logger.info("isLeader-->" + isLeader);

            }
        };
//        zkClient.create(MASTER_PATH, serverId.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, sc,);
    }


    /**
     * 检查有没有群首
     *
     * @return
     */
    void checkExistsMaster() {
        AsyncCallback.DataCallback cb = new AsyncCallback.DataCallback() {

            public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
                switch (KeeperException.Code.get(rc)) {
                    case CONNECTIONLOSS:
                        checkExistsMaster();
                        break;
                    case NONODE:
                        runForMaster();
                        return;
                    default:
                        ;
                }
            }
        };
//        zkClient.data(MASTER_PATH, false, cb, null);
    }
}
