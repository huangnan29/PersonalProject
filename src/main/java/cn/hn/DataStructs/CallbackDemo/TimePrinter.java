package cn.hn.DataStructs.CallbackDemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-10-28 下午8:06
 * @desc : TODO
 */
public class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        Date now = new Date();
        System.out.println("At the tone,the time is " + now);
        Toolkit.getDefaultToolkit().beep();
    }
}
