package cn.hn.GC;

import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-12-3 下午9:47
 * @desc : TODO
 */
public class TestClass {
    private int m;
    public int inc(){
        return m+1;
    }

    public static void main(String[] args) throws Exception {
        ClassLoader myload = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String FileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(FileName);
                    if (is == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    //e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
//                return super.loadClass(name);
            }
        };

        Object obj = myload.loadClass("cn.hn.GC.TestClass");


    }
}