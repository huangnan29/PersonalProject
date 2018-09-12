package cn.hn.zookeeper;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-10 下午5:11
 **/
import org.apache.zookeeper.*;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

public class Client implements Watcher {
    ZooKeeper zk;
    String hostPort;

    Client(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws Exception {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    String queueCommand(String command) throws Exception {
        while (true) {
            try {
                String name = zk.create("/tasks/task-",
                        command.getBytes(), OPEN_ACL_UNSAFE,
                        CreateMode.EPHEMERAL_SEQUENTIAL);
                return name;
//                break;
            } catch (KeeperException.NodeExistsException e) {
                throw new Exception(e.code().name() + " already appears to be running");
            } catch (KeeperException.ConnectionLossException e) {
            }
        }

    }
    public void process (WatchedEvent e){
        System.out.println(e);
    }
    public static void main (String args[]) throws Exception {
        Client c = new Client("localhost:2181");
        c.startZK();
        String name = c.queueCommand("test");
        System.out.println("Created " + name);
        Thread.sleep(600000);
    }
}
