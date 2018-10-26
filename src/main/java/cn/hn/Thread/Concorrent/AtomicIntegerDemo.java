package cn.hn.Thread.Concorrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-10-25 下午4:56
 * @desc : TODO
 **/
public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();

    public static class AddThread implements Runnable{

        @Override
        public void run() {
            for (int k = 0; k <10000 ; k++) {
                i.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int k = 0; k <10 ; k++) {
            ts[k] = new Thread(new AddThread());
        }

        for (int k = 0; k <10 ; k++) {
            ts[k].start();
        }
        for (int k = 0; k <10 ; k++) {
            ts[k].join();
        }
        System.out.println(i);
    }
}
