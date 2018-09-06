package cn.hn.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-6 下午2:48
 **/
public class Master implements Watcher {

    ZooKeeper zk;
    String hostPort;

    Master(String port){
        this.hostPort = port;
    }

    public void zkStart () throws IOException {
        zk = new ZooKeeper(hostPort,150000,this);
    }


    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public static void main(String[] args) throws Exception {
        Master m = new Master("localhost:2181");
        m.zkStart();
        Thread.sleep(10000);


    }
}
