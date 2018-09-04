package cn.hn.zookeeper;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

public class ZKClientDemo {

    public static void main(String[] args) throws InterruptedException {
        String zkServer = "127.0.0.1:2181";
        int connectionTimeout = 3000;
        ZkClient zkClient = new ZkClient(zkServer, connectionTimeout);

        //创建持久化节点
        final String PersistentPath = "/zk-data";
        if (zkClient.exists(PersistentPath)){
            zkClient.delete(PersistentPath);
        }

        zkClient.createPersistent(PersistentPath);

        //节点数据写入
        zkClient.writeData(PersistentPath, "tets");

        //读取节点数据
        final String data = zkClient.<String>readData(PersistentPath, true);
        System.out.println(data);

        //注册监听器，监听数据变化
        zkClient.subscribeDataChanges(PersistentPath, new IZkDataListener() {
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("HandleDataChange,dataPath:" + dataPath + "Data:" + data);
            }

            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("handleDataDeleted,dataPath"+dataPath);

            }
        });

        //修改数据
        zkClient.writeData(PersistentPath,"test_data2");

        //删除节点
        zkClient.delete(PersistentPath);
        Thread.sleep(Integer.MAX_VALUE);

    }
}
