package cn.hn.kafkaDemo;


import kafka.admin.AdminUtils;
import kafka.admin.BrokerMetadata;
import kafka.server.ConfigType;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;
import scala.collection.Map;
import scala.collection.Seq;

import java.util.Properties;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-11-14 下午2:45
 * @desc : TODO
 **/
public class CreateTopicAdminUtil {

    private static final String ZK_CONNECT = "localhost:2181";
    private static final int SESSION_TIMEOUT = 30000;
    private static final int CONNECT_TIMEOUT = 30000;

//    static {
//        ZkUtils zkUtils = ZkUtils.apply(ZK_CONNECT, SESSION_TIMEOUT, CONNECT_TIMEOUT, JaasUtils.isZkSecurityEnabled());
//    }

    /**
     * 创建主题
     *
     * @param topic      主题
     * @param partition  分区数
     * @param replica    副本数
     * @param properties 主题配置信息
     */
    public static void createTopic(String topic, int partition, int replica, Properties properties) {
        ZkUtils zkUtils = null;
        try {
            ZkUtils.apply(ZK_CONNECT, SESSION_TIMEOUT, CONNECT_TIMEOUT, JaasUtils.isZkSecurityEnabled());
            if (!AdminUtils.topicExists(zkUtils, topic)) {
                AdminUtils.createTopic(zkUtils, topic, replica, partition, properties, AdminUtils.createTopic$default$6());
            } else {
                System.out.println("topic exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkUtils.close();
        }

    }


    /**
     * 修改主题级别配置
     *
     * @param topic      主题信息
     * @param properties 主题配置信息
     */
    public static void modifyTopicConfig(String topic, Properties properties) {
        ZkUtils zkUtils = null;
        try {
            //实例化 ZkUtils
            zkUtils = ZkUtils.apply(ZK_CONNECT, SESSION_TIMEOUT, CONNECT_TIMEOUT, JaasUtils.isZkSecurityEnabled());
            //首先获取当前己有的配置,这里是查询主题级别的配置,因此指定配置类型为 Topic
            Properties curProp = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(), topic);// 添加新修改的配置第6章
            curProp.putAll(properties);
            AdminUtils.changeTopicConfig(zkUtils, topic, curProp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkUtils.close();
        }

    }

    /**
     * 分区副本重新分配
     */
    public static void repartition(String topic) {
        ZkUtils zkUtils = null;
        try {
            //1. 实例化 ZkUtils
            zkUtils = ZkUtils.apply(ZK_CONNECT, SESSION_TIMEOUT, CONNECT_TIMEOUT, JaasUtils.isZkSecurityEnabled());
            // 2. 获取代理元数据信息
            Seq<BrokerMetadata> brokerMeta = AdminUtils.getBrokerMetadatas(zkUtils, AdminUtils.getBrokerMetadatas$default$2(), AdminUtils.getBrokerMetadatas$default$3());
            // 3. 生成分区副本分配方案: 2 个分区、 3 个副本
            Map<Object, Seq<Object>> replicaAssign = AdminUtils.assignReplicasToBrokers(brokerMeta, 2, 3, AdminUtils.assignReplicasToBrokers$default$4(),
                    AdminUtils.assignReplicasToBrokers$default$5());
            // 4. 修改分区副本分配方案
            AdminUtils.createOrUpdateTopicPartitionAssignmentPathInZK(zkUtils, topic, replicaAssign, null, true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 释放与 ZooKeeper 的连接
            zkUtils.close();
        }
    }

    /**
     * 删除主题
     *
     * @param topic 主题
     */
    public static void deleteTopci(String topic) {
        ZkUtils zkUtils = null;
        try {
            zkUtils = ZkUtils.apply(ZK_CONNECT, SESSION_TIMEOUT, CONNECT_TIMEOUT, JaasUtils.isZkSecurityEnabled());
            AdminUtils.deleteTopic(zkUtils, topic);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zkUtils.close();
        }

    }
}
