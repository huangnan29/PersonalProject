package cn.hn.DataStructs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-21 下午3:09
 * @desc : TODO
 **/
public class HashMapTest {
    public static void collectionTest(){
        Map<String, String> map = new HashMap<String, String>();

        map.put("hello", "world");
        map.put("java", "c++");
        map.put("sql", "os");

        System.out.println(map);

        // A:获取所有的键
        Collection<String> set = map.keySet();

        // B:遍历键的集合，获取得到每一个键
        for (String key : set) {
            // C:根据键查询值
            String value = map.get(key);
            System.out.println(key + "---" + value);
        }

    }


    public static void setTest(){
        Map<String, String> map = new HashMap<String, String>();

        map.put("hello", "world");
        map.put("java", "c++");
        map.put("sql", "os");
        Map.Entry.comparingByKey();

        System.out.println(map);

        // A:获取所有的键
        Set<String> set = map.keySet();

        // B:遍历键的集合，获取得到每一个键
        for (String key : set) {
            // C:根据键查询值
            String value = map.get(key);
            System.out.println(key + "---" + value);
        }

    }

    public static void main(String[] args) {
        HashMapTest demo = new HashMapTest();
        demo.collectionTest();
        demo.setTest();
    }
}
