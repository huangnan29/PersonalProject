package cn.hn.Net.UDP;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-12-17 上午8:18
 * @desc : TODO
 **/
public class UDPClientDemo {

    public static void main(String[] args) throws IOException {
        //1.创建客户端
        DatagramSocket client = new DatagramSocket(6666);

        //2. 准备数据
//        String msg = new String("hn");
//        byte[] data = msg.getBytes();

        Double num = 89.12;
        byte[] data = convert(num);


        //3.打包(发送地址 端口)
        DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8888));

        //4.发送数据
        client.send(packet);

        //5. 关闭资源
        client.close();

    }


    public static byte[] convert(Double input) throws IOException {

        byte[] data = null;
        ByteOutputStream bos = new ByteOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);

        dos.writeDouble(input);
        dos.flush();
        data = bos.toByteArray();

        dos.close();

        return data;


    }
}
