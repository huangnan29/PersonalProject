package cn.hn.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-27 上午11:21
 * @desc : TODO
 **/
public class UDPServerTest {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String str = "hello world";
        //构造用于发送的数据包，指定主机和端口号
        DatagramPacket packet = new DatagramPacket(str.getBytes(),
                str.length(), InetAddress.getByName("localhost"), 5555);
        ds.send(packet);

        //读取从客户端发送过来的响应
        byte[] buffer = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(buffer,buffer.length);
        ds.receive(packet2);
        String str2 = new String(buffer,0,packet2.getLength());
        System.out.println(str2);
        ds.close();
    }
}
