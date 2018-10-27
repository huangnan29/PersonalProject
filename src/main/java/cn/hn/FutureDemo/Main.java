package cn.hn.FutureDemo;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-10-26 上午10:02
 * @desc : TODO
 **/
public class Main {
    public static void main(String[] args) {
        Client client = new Client();

        Data data = client.request("name");
        System.out.println("请求完毕");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据 = " +data.getResult());

    }
}
