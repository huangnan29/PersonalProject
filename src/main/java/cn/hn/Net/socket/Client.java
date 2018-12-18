package cn.hn.Net.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-12-17 下午8:34
 * @desc : TODO
 * 1.创建客户端  必须制定地址,端口
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client=  new Socket("localhost",8888);

    }
}
