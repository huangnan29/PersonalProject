package cn.hn.Thread.multiThread.chapter3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-20 上午9:46
 * @desc : TODO 读写锁/重入锁 结合 countDownLatch 测试
 * @explain: 读写锁队读操作的非租塞行为
 **/
public class WriteReadLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();


    /**
     * 定义计线程数器
     */
    static final CountDownLatch readEnd = new CountDownLatch(18);
    static final CountDownLatch writeEnd = new CountDownLatch(18);

    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            return value;

        }finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock,int index) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = index;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {



        long startTime=System.currentTimeMillis();
        System.out.println(startTime);
        final WriteReadLockDemo demo = new WriteReadLockDemo();
        Runnable readRunable = new Runnable() {
            public void run() {
                try {
//                    demo.handleRead(readLock);
                    demo.handleRead(lock);
                    readEnd.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunable = new Runnable() {
            public void run() {
                try {
//                    demo.handleWrite(writeLock,new Random().nextInt());
                    demo.handleWrite(lock,new Random().nextInt());
                    writeEnd.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };



        for (int i = 0; i < 18; i++) {
            new Thread(readRunable).start();
        }

        readEnd.await();
        long ReadStopTime=System.currentTimeMillis();
        System.out.println("读锁运行时间： "+(ReadStopTime - startTime)+"ms");

        for (int i = 0; i < 18; i++) {
            new Thread(writeRunable).start();
        }
        writeEnd.await();
        long WriteStopTime=System.currentTimeMillis();
        System.out.println("写锁运行时间： "+(WriteStopTime - ReadStopTime)+"ms");
    }



}
