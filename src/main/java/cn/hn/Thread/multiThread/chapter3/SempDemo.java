package cn.hn.Thread.multiThread.chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-20 上午8:44
 * @desc : TODO
 **/
public class SempDemo implements Runnable {
    final Semaphore semp = new Semaphore(5);

    public void run(){
        try {
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId()+":Done");
            semp.release();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SempDemo demo = new SempDemo();
        for (int i = 0; i <20 ; i++) {
            exec.submit(demo);
        }
    }

}
