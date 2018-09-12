package cn.hn.Thread;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-7 上午9:58
 **/
public class Tom implements Student {

    private String name = "Tom";
    public void resolveQuestion(Callback callback) {
        // 模拟解决问题
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        // 回调，告诉老师作业写了多久
        callback.tellAnswer(13,name);
    }

}
