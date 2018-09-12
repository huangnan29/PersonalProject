package cn.hn.Thread;


/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-7 上午9:56
 **/
public class Ricky implements Student {

    private String name = "Ricky";
    public void resolveQuestion(Callback callback) {
        // 模拟解决问题
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        // 回调，告诉老师作业写了多久
        callback.tellAnswer(3,name);
    }

}
