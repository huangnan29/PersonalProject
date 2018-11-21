package cn.hn.kafkaDemo.SingleProducer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.log4j.Logger;

//import javax.security.auth.callback.Callback;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-11-14 下午5:35
 * @desc : TODO
 **/
public class QuotationProducer {
    private static final Logger LOG = Logger.getLogger(QuotationProducer.class);
    /**
     * 设置实例生产消息的总数
     */
    private static final int MSG_SIZE = 100;
    /**
     * 川主题名称
     */
    private static final String TOPIC = "stock-quotation";
    /**
     * Kafka 集群
     */

    private static final String BROKER_LIST = "localhost:9092";
    private static KafkaProducer<String, String> producer = null;

    static {
        //1. 构造用于实例化 KafkaProducer 的 Properties 信息
        Properties configs = initConfig();
        // 2. 初始化一个 KafkaProducer
        producer = new KafkaProducer<String, String>(configs);
    }


    /**
     * 初始化 Kafka 配置
     *
     * @return
     */
    private static Properties initConfig() {
        Properties properties = new Properties();
        // Kafka broker 列表
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        //设置序列化类
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        return properties;
    }


    /**
     * 生产股票行情信息
     *
     * @return
     */
    private static StockQuotationinfo createQuotationinfo() {
        StockQuotationinfo quotationinfo = new StockQuotationinfo();
        //随机产生 l 到 10 之间的整数,然后与 600100 相加组成股票代码
        Random r = new Random();
        Integer stockCode = 600100 + r.nextInt(10);
        //随机产生一个 0 到 1 之间的浮点数
        float random = (float) Math.random();
        //设置涨跌规则
        if (random / 2 < 0.5) {
            random = -random;
            DecimalFormat decimalFormat = new DecimalFormat(".00"); //设置保存两位有效数字
            quotationinfo.setCurrentPrice(Float.valueOf(decimalFormat.format(11 + random)));// 设置最新价在 11 元浮动
            quotationinfo.setPreClosePrice(11.80f);// 设置昨日收盘价为固定值
            quotationinfo.setOpenPrice(11.5f);// 设置开盘价
            quotationinfo.setLowPrice(10.5f); // 设置最低价,并不考虑 10 屯 限制,
            //以及当前价是否已是最低价
            quotationinfo.setHighPrice(12.5f); //设置最高价 , 并不考虑 10 宅限制 ,
            //以及当前价是否已是最高价
            quotationinfo.setStockCode(stockCode.toString());
            quotationinfo.setTradeTime(System.currentTimeMillis());
            quotationinfo.setStockName(" 股票- " + stockCode);

        }
        return quotationinfo;
    }

    public static void main(String[] args) {
        ProducerRecord<String, String> record = null;
        StockQuotationinfo quotationinfo = null;
        try {
            int num = 0;
            for (int i = 0; i < MSG_SIZE; i++) {
                quotationinfo = createQuotationinfo();
                record = new ProducerRecord<String, String>(TOPIC, null,
                        quotationinfo.getTradeTime(), quotationinfo.getStockCode(),
                        quotationinfo.toString());

                //无回调发送消息
//                producer.send(record); //异步发送消息

                producer.send(record, new Callback() {
//                    @Override
                    public void onCompletion (RecordMetadata metaData, Exception exception) {
                        if (null != exception) {// 发送异常记录异常信息
                            LOG.error("Send message occurs exception . ", exception);
                        }
                        if (null != metaData) {
                            LOG.info(String.format("offset : %s , partition : %s", metaData.offset(), metaData.partition()));
                        }
                    }
                });

                if (num++ % 10 == 0) {
                    Thread.sleep(2000L); //休眠 2s
                }
            }
        } catch (InterruptedException e) {
            LOG.error("Send message occurs exception ", e);
        } finally {
            producer.close();
        }
    }

}
