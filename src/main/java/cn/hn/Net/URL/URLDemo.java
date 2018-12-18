package cn.hn.Net.URL;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-12-17 上午7:50
 * @desc : TODO
 **/
public class URLDemo {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=hn");

        System.out.println("协议:" + url.getProtocol());
        System.out.println("域名:" + url.getHost());
        System.out.println("端口:" + url.getPort());
        System.out.println("资源:" + url.getFile());
        System.out.println("锚点:" + url.getFile());
        System.out.println("参数:" + url.getFile());

        url = new URL("http://www.baidu.com/a");

        url = new URL(url, "b.txt");

    }
}
