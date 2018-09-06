package cn.hn.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-6 上午8:39
 * @desc : 监听案例
 **/
public class WatcherDemo implements Watcher {



    public void process(WatchedEvent event) {
        System.out.println("Enter the process method,the event is :"+event);
        Event.EventType type = event.getType();
        switch (type) {
            case NodeDeleted:
                System.out.println("新建节点:" + event.getPath());
        }
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String connectionString = "localhost:2181";

        //ZooKeeper(String connectString, int sessionTimeout, Watcher watcher, boolean canBeReadOnly)
        ZooKeeper zooKeeper = new ZooKeeper(connectionString, 15 * 1000, new WatcherDemo(), false);


        ZooKeeper zooKeeper1 = new ZooKeeper(connectionString, 15 * 1000, new WatcherDemo(), false);
        //public String create(String path, byte[] data, List<ACL> acl, CreateMode createMode) ;
        zooKeeper.create("/myEphmeralPath1", "random".getBytes(), OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        zooKeeper.close();
        TimeUnit.SECONDS.sleep(5);

    }
}
