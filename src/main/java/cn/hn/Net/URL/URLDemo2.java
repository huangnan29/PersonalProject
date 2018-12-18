package cn.hn.Net.URL;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-12-17 上午8:01
 * @desc : TODO
 **/
public class URLDemo2 {
    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");

//        InputStream is = url.openStream();
//        byte[] flush = new byte[1024];
//        int len = 0;
//        while (-1 != (len = is.read(flush))){
//            System.out.println(new String(flush,0,len));
//        }
//        is.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"), StandardCharsets.UTF_8));
        String msg = null;
        while ((msg = br.readLine()) != null) {
//            System.out.println(msg);
            bw.append(msg);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
