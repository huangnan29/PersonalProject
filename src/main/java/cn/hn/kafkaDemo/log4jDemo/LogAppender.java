package cn.hn.kafkaDemo.log4jDemo;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;


/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-11-15 上午9:04
 * @desc : TODO
 **/
public class LogAppender extends DailyRollingFileAppender {

    @Override
    public boolean isAsSevereAsThreshold(Priority priority){
        return this.getThreshold().equals(priority);
    }

}
