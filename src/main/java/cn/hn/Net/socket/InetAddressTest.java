package cn.hn.Net.socket;


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-27 上午10:16
 * @desc : TODO
 **/
public class InetAddressTest {


    public static void main(String[] args) throws UnknownHostException {
//        assert args[0] = "baidu.com";
        if (args.length > 0 ){
            String host = args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress a : addresses){
                System.out.println(a);
            }
        }else {
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
        }
    }
}
