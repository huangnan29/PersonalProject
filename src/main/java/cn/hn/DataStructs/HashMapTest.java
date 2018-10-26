package cn.hn.DataStructs;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-21 下午3:09
 * @desc : TODO
 **/
public class HashMapTest {
    public static void collectionTest() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("1", "one");
        map.put("2", "tow");
        map.put("3", "three");
        map.put("4", "four");
        map.put("5", "five");
        map.put("6", "six");
        map.put("7", "seven");
        map.put("8", "eight");
        map.put("9", "nine");
        map.put("10", "ten");

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


    public static void setTest() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("1", "one");
        map.put("2", "tow");
        map.put("3", "three");
        map.put("4", "four");
        map.put("5", "five");
        map.put("6", "six");
        map.put("7", "seven");
        map.put("8", "eight");
        map.put("9", "nine");
        map.put("10", "ten");

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

    public static Map<String, String> initMap() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("1", "one");
        map.put("2", "tow");
        map.put("3", "three");
        map.put("4", "four");
        map.put("5", "five");
        map.put("6", "six");
        map.put("7", "seven");
        map.put("8", "eight");
        map.put("9", "nine");
        map.put("10", "ten");

        return map;

    }



    public static void main(String[] args) {

        HashMapTest demo = new HashMapTest();
        Map<String, String> map = demo.initMap();
//        System.out.println(map.keySet());
        Map<String, String> mapInsert = new HashMap<>();
        mapInsert.put("16", "1six");
        mapInsert.put("17", "1seven");
        mapInsert.put("18", "1eight");
        mapInsert.put("19", "1nine");
        mapInsert.put("110", "1ten");
        map.putAll(mapInsert);
//        for(Map.Entry<String,String> test : map.entrySet()) {
//            System.out.println(test);
//        }


        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }


//        ConcurrentHashMap
        //        System.out.println(map.keySet());

    }
}
