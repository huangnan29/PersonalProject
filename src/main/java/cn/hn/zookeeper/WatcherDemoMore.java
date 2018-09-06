package cn.hn.zookeeper;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-6 上午8:49
 **/
public class WatcherDemoMore implements Watcher {

    public void process(WatchedEvent event) {
        System.out.println("Enter the process method,the event is :" + event);
        Event.EventType type = event.getType();
        switch (type) {
            case NodeCreated:
                System.out.println("新建节点:" + event.getPath());
            case NodeDeleted:
                System.out.println("删除节点:" + event.getPath());
            case NodeDataChanged:
                System.out.println("修改节点:" + event.getPath());
            case NodeChildrenChanged:
                System.out.println("子节点:" + event);
        }
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        WatcherDemoMore watcherDemo = new WatcherDemoMore();
        String connectionString = "localhost:2181";
        ZooKeeper zooKeeper = new ZooKeeper(connectionString, 15 * 1000, watcherDemo, false);
        String path = "/watcherdemo01";
        String childPath = "/watcherdemo01/child01";

        Stat stat = zooKeeper.exists(path, watcherDemo);
        if (stat == null) {
            zooKeeper.create(path, "random".getBytes(), OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        if (stat != null) {
            zooKeeper.delete(path, stat.getVersion());
        }
        TimeUnit.SECONDS.sleep(5);
        zooKeeper.close();
    }
}
