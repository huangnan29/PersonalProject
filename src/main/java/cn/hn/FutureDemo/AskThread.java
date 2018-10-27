package cn.hn.FutureDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-10-26 下午5:51
 * @desc : TODO
 **/
public class AskThread implements Runnable {
    CompletableFuture<Integer> re = null;

    public AskThread(CompletableFuture<Integer> re){
        this.re = re;
    }

    @Override
    public void run() {
        int myRe = 0;
        try {
            myRe = re.get() * re.get();
        }catch (Exception e){

        }
        System.out.println(myRe);

    }

    public static void main(String[] args) throws InterruptedException {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new AskThread(future)).start();
        Thread.sleep(100);
        future.complete(20);
    }
}
