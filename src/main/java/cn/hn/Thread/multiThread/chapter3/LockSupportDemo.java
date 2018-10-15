package cn.hn.Thread.multiThread.chapter3;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-20 下午2:06
 * @desc : TODO
 **/
public class LockSupportDemo {
    public static Object u = new Object();

    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name){
            super.setName(name);
        }


        public void run(){
            synchronized (u){
                System.out.println("in:"+getName());
                LockSupport.park();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100000);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();

    }



}
