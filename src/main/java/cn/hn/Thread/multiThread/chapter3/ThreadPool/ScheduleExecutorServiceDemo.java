package cn.hn.Thread.multiThread.chapter3.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-21 上午7:59
 * @desc : TODO 定时调度线程池
 **/
public class ScheduleExecutorServiceDemo {

    private static Object runAB;

    public static class runAB implements Runnable{

        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(System.currentTimeMillis()/1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        Runnable test = new runAB();
//        ses.scheduleAtFixedRate(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println(System.currentTimeMillis()/1000);
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//        } ,0,2, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(test,0,2,TimeUnit.SECONDS);




    }



}
