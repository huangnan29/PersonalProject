package cn.hn.Net.UDP;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import javax.xml.bind.SchemaOutputResolver;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-12-17 上午8:18
 * @desc : TODO 思考 数据加类型发送到服务端
 **/
public class UDPServerDemo {

    public static void main(String[] args) throws IOException {
        //1.创建服务器接收端口
        DatagramSocket server = new DatagramSocket(8888);


        //2.打包

        byte[] container = new byte[1024];

        //3.封装成DatagramPacket包
        DatagramPacket packet = new DatagramPacket(container, container.length);

        //4.接收数据
        server.receive(packet);

        //5.分析数据

        byte[] data = packet.getData();
//        int len = packet.getLength();
//        System.out.println(new String(data,0,len));

        double out = convert(data);
        System.out.println(out);

        //6.释放资源
        server.close();


    }

    /**
     * 字节数组+data输入流
     * @param data
     * @return
     */

    public static Double convert(byte[] data) throws IOException {

        DataInputStream dis  = new DataInputStream(new ByteArrayInputStream(data));
        Double num = dis.readDouble();

        return num;
    }

}

