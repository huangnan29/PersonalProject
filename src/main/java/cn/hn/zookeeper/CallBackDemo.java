package cn.hn.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-6 上午8:52
 * @desc : create callback
 **/
public class CallBackDemo implements Watcher {
    public static void main(String[] args) throws InterruptedException, IOException {
        String connectionString = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
        ZooKeeper zooKeeper = new ZooKeeper(connectionString, 15 * 1000, new CallBackDemo(), false);
        String path = "/callBackDemo";
        String params = "123";
        zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, new AsyncCallback.StringCallback() {
            public void processResult(int rc, String path, Object ctx, String name) {
                System.out.println("Object ctx 参数对应于create 方法最后一个参数");
                System.out.println(ctx.toString());
                KeeperException.Code code = KeeperException.Code.get(rc);
                switch (code) {
                    case OK:
                    case NOAUTH:
                    case NONODE:
                    case APIERROR:
                    case NOTEMPTY:
                    case AUTHFAILED:
                    case BADVERSION:
                    case INVALIDACL:
                    case NODEEXISTS:
                    case NOTREADONLY:
                    case SYSTEMERROR:
                    case BADARGUMENTS:
                    case SESSIONMOVED:
                    case UNIMPLEMENTED:
                    case CONNECTIONLOSS:
                    case SESSIONEXPIRED:
                    case INVALIDCALLBACK:
                    case MARSHALLINGERROR:
                    case OPERATIONTIMEOUT:
                    case DATAINCONSISTENCY:
                    case RUNTIMEINCONSISTENCY:
                    case NOCHILDRENFOREPHEMERALS:
                }
            }
        }, params);
        TimeUnit.SECONDS.sleep(10);
    }

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
}
