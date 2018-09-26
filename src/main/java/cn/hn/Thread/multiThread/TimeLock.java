package cn.hn.Thread.multiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date  : 18-9-17 上午8:33
 * @desc  : TODO 设置失效时间
 **/
public class TimeLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();


    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)){
                /**
                 * 此处设为6000大于5s  会获取失败 返回获取锁失败
                 * 若设为小于5s 则程序正常返回
                 */
                Thread.sleep(6000);
            }else {
                System.out.println("get lock failed!");
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if (lock.isHeldByCurrentThread())
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        TimeLock tl1 = new TimeLock();
        Thread t1 = new Thread(tl1);
        Thread t2 = new Thread(tl1);
        t1.start();
        t2.start();
    }
}
