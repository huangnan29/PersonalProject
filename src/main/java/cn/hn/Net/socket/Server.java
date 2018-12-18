package cn.hn.Net.socket;

import kafka.network.SocketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-12-17 下午8:22
 * @desc : TODO
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        System.out.println("建立连接");
    }
}
