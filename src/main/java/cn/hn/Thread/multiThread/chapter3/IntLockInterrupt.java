package cn.hn.Thread.multiThread.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date  : 18-9-17 上午8:05
 * @desc  : 重入锁
 **/
public class IntLockInterrupt implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    /**
     * 控制枷锁顺序.方便构造死锁
     */

    public IntLockInterrupt(int lock){
        this.lock = lock;
    }


    /**
     * 线程方法
     */
    public void run() {
        try {
            if (lock == 1){
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){

                }
                lock2.lockInterruptibly();
            }else{
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){}
                lock1.lockInterruptibly();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if (lock1.isHeldByCurrentThread())
                lock1.unlock();
            if (lock2.isHeldByCurrentThread())
                lock2.unlock();
            System.out.println(Thread.currentThread().getId() + ":线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IntLockInterrupt r1 = new IntLockInterrupt(1);
        IntLockInterrupt r2 = new IntLockInterrupt(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();


    }
}
