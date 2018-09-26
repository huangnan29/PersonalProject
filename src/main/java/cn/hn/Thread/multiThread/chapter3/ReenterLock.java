package cn.hn.Thread.multiThread.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-17 上午7:44
 **/
public class ReenterLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    public void run() {
        for (int j = 0; j < 1000000; j++) {
            lock.lock();

            try {
                i++;
            }finally {
                lock.unlock();
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock lock1 = new ReenterLock();
        Thread t1 = new Thread(lock1);
        Thread t2 = new Thread(lock1);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(i);

    }

}
