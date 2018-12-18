package cn.hn.MyCollection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-12-5 上午12:09
 * @desc : TODO
 */
public class Test01 {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaa");
        list.add(new Date());
        System.out.println(list.size());
        System.out.println();
    }
}
