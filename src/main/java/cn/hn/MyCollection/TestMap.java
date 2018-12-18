package cn.hn.MyCollection;

import cn.hn.DataStructs.HashMapTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-12-5 下午9:08
 * @desc : TODO
 */
public class TestMap {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("hn",new Wife("张曼玉"));
    }



}


class Wife {
    String Name;

    public Wife(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
