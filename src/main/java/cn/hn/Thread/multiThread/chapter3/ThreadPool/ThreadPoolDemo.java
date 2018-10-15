package cn.hn.Thread.multiThread.chapter3.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-20 下午4:35
 * @desc : TODO
 **/
public class ThreadPoolDemo {

    public static class MyTask implements Runnable{
        public void run(){
            System.out.println(System.currentTimeMillis() + ":Thread ID:"+Thread.currentThread().getId());

            try {
                Thread.sleep(1000);

            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }




    public static void main(String[] args) {
        MyTask task  = new MyTask();

        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i <10 ; i++) {
            es.submit(task);
        }

    }


}

