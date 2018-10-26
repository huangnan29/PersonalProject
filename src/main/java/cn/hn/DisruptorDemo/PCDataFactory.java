package cn.hn.DisruptorDemo;

import com.lmax.disruptor.EventFactory;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-10-26 上午9:04
 * @desc : TODO
 **/
public class PCDataFactory implements EventFactory<PCData> {
    @Override
    public PCData newInstance() {
        return new PCData();
    }
}
