package cn.hn.FutureDemo;

import java.util.concurrent.CompletionStage;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-10-26 上午10:00
 * @desc : TODO
 **/
public class Client {
    public Data request(final String queryStr){
        final FutureData future = new FutureData();

        new Thread(){
            public void run(){
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }
        }.start();
        return future;
    }
//    CompletionStage
}
