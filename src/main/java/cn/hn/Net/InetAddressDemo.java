package cn.hn.Net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-12-17 上午7:30
 * @desc : TODO
 **/
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress.getAllByName("192.168.2.190");
        InetAddress local = InetAddress.getLocalHost();
        System.out.println(local.toString());
        System.out.println(local.getAddress());
        System.out.println(local.getHostAddress());

        InetAddress baiduAddr = InetAddress.getByName("baidu.com");
        System.out.println(baiduAddr.getHostAddress());


        InetSocketAddress addr = new InetSocketAddress("localhost",9999);


    }
}
