package cn.hn.FutureDemo;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-10-26 上午9:49
 * @desc : TODO
 **/
public class RealData implements Data {

    protected final String result;
    public RealData(String para) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <10 ; i++) {
            sb.append(para);
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        result =  sb.toString();
    }


    @Override
    public String getResult() {
        return result;
    }
}
