package cn.hn.Net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-27 上午10:30
 * @desc : TODO
 **/
public class EchoServer {
    public static void main(String[] args) throws IOException {

        try (ServerSocket s = new ServerSocket(8189)) {
            try (Socket incoming = s.accept()) {
                InputStream InStream = incoming.getInputStream();
                OutputStream OutStream = incoming.getOutputStream();

                try(Scanner in = new Scanner(InStream)){
                    PrintWriter out = new PrintWriter(OutStream,true /* autoflush*/) ;
                    out.println("hello print bye to exit!");

                    boolean done = false;
                    while (!done && in.hasNextLine()){
                        String line = in.nextLine();
                        out.println(line);
                        if (line.trim().equals("bye")) done = true;

                    }
                }

            }
        }
    }
}
