package cn.hn.DisruptorDemo;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-10-26 上午9:08
 * @desc : TODO
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Executor executors = Executors.newCachedThreadPool();


        PCDataFactory factory = new PCDataFactory();

        int bufferSize = 1<<10;
//        System.out.println(bufferSize);
        Disruptor<PCData> disruptor = new Disruptor<PCData>(factory,
                bufferSize,
                executors,
                ProducerType.MULTI,
                new BlockingWaitStrategy()
                );
        disruptor.handleEventsWithWorkerPool(
                new Cosumer(),
                new Cosumer(),
                new Cosumer(),
                new Cosumer()
        );
        disruptor.start();

        RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();
        Producer producer = new Producer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true ; l++) {
            bb.putLong(0,1);
            producer.pushData(bb);
            Thread.sleep(100);
            System.out.println("add data " +1);
        }
        
    }
}
