package cn.hn.DisruptorDemo;

import com.lmax.disruptor.WorkHandler;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-10-26 上午9:01
 * @desc : TODO
 **/
public class Cosumer implements WorkHandler<PCData> {
    @Override
    public void onEvent(PCData event) throws Exception {
        System.out.println(Thread.currentThread().getId()+":Event:--"+event.getValue() * event.getValue() + "--");
    }
}
