package cn.hn.GC;
import java.lang.Object;
public class TestHeapGC {
    public static void main(String[] args) {
        byte[] b1= new byte[1024 * 1024/2];
        byte[] b2 = new byte[1024*1024/2];
        b2 = null;
        b2 = new byte[1024*1024*8];
        System.gc();
    }
}
