package cn.hn.Thread.multiThread;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-13 上午9:01
 **/
public class JoinMain {

    public volatile static int i = 0 ;
    public static class AddThread extends Thread{
        @Override
        public void run(){
            for (i = 0;i<10000000;i++);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
        //等待at执行完成
        at.join();
        System.out.println(i);

    }
}
