package cn.hn.Thread.multiThread.chapter3;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-20 下午4:29
 * @desc : TODO
 **/
public class LockSupportIntDemo {

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
                if (Thread.interrupted()){
                    System.out.println(getName() + "被中断了");
                }
            }
            System.out.println("执行结束");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.interrupt();
        LockSupport.unpark(t2);
    }

}
