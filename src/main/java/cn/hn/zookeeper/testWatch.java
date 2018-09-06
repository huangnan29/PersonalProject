package cn.hn.zookeeper;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.data.Stat;


import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-6 上午8:16
 * @desf : 测试zookeeper监视机制
 **/
public class testWatch implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    public static Stat stat = new Stat();
    ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        String p = "/testaa";
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new testWatch());
        connectedSemaphore.await();
        //exists register watch
        zooKeeper.exists(p, true);
        String path = zooKeeper.create(p, "456".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        //get register watch
        zooKeeper.getData(path, true, stat);
        zooKeeper.setData(path, "hhhh".getBytes(), -1);
        zooKeeper.exists(path, true);
        //exists register watch
        zooKeeper.delete(path, -1);

    }

    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()) {
            if (Event.EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();
                System.out.println("Zookeeper session established");
            } else if (Event.EventType.NodeCreated == event.getType()) {
                System.out.println("success create znode");

            } else if (Event.EventType.NodeDataChanged == event.getType()) {
                System.out.println("success change znode: " + event.getPath());

            } else if (Event.EventType.NodeDeleted == event.getType()) {
                System.out.println("success delete znode");

            } else if (Event.EventType.NodeChildrenChanged == event.getType()) {
                System.out.println("NodeChildrenChanged");

            }

        }
    }
}
