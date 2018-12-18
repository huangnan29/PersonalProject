package cn.hn.DataStructs.CallbackDemo;

import cn.hn.interfc.MyOuterStatic;

import javax.swing.*;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-10-28 下午8:19
 * @desc : TODO
 */
public class PrinterTest {
    public static void main(String[] args) {
        MyOuterStatic.Myinner test = new MyOuterStatic.Myinner();
        test.innerMethod();
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(10000,listener);
        t.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);


    }
}
