package cn.hn.zookeeper;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-10 上午11:02
 **/

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.AsyncCallback.*;

import java.io.IOException;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

public class AsymMaster2 implements Watcher{

    private static boolean isLeader = false;

    AsymMaster2(){

    }

    ZooKeeper zk;
    String serverId = "10";
    StringCallback masterCreateCallback = new StringCallback() {
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (KeeperException.Code.get(rc)) {
                case CONNECTIONLOSS:
                    checkMaster();
                    return;
                case OK:
                    isLeader = true;
                    break;
                default:
                    isLeader = false;
            }
            System.out.println("I'm " + (isLeader ? "" : "not ") +
                    "the leader");
        }
    };
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public void zkStart () throws IOException {
        zk = new ZooKeeper("localhost:2181",150000,this);
    }
    void runForMaster() {
        this.zk.create("/master", serverId.getBytes(), OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL, masterCreateCallback, null);
    }

     DataCallback masterCheckCallback = new DataCallback() {
        public void processResult(int rc, String path, Object ctx, byte[] data,
                                  Stat stat) {
            switch (KeeperException.Code.get(rc)) {
                case CONNECTIONLOSS:
                    checkMaster();
                    return;
                case NONODE:
                    runForMaster();
                    return;
            }
        }
    };

     void checkMaster() {
        zk.getData("/master", false, masterCheckCallback, null);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        AsymMaster2 master = new AsymMaster2();
        master.zkStart();
        master.runForMaster();
        Thread.sleep(600000);
    }

}
