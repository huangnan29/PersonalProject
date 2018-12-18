package cn.hn.MyCollection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-12-5 下午10:35
 * @desc : TODO
 */
public class MyHashMap {
    LinkedList[] arr = new LinkedList[999];
    int size;

    public void put(Object key, Object value) {
        MyEntry me = new MyEntry(key, value);

        int a = key.hashCode() % arr.length;
        if (arr[a] == null) {
            LinkedList list = new LinkedList<>();
            list.add(me);
            arr[a] = list;
        } else {
            LinkedList list = arr[a];
            for (int i = 0; i <list.size() ; i++) {
                MyEntry e = (MyEntry) list.get(i);
                if (e.key.equals(key)){
                    e.value = value;
                    return;
                }
            }
            arr[a].add(me);
        }

        size++;
    }


    public Object get(Object key){
        int a = key.hashCode() % arr.length;
        if (arr[a] != null) {
            LinkedList list = arr[a];
            for (int i = 0; i <list.size() ; i++) {
                MyEntry e = (MyEntry) list.get(i);
                if (e.key.equals(key)){
                    return e.value;
                }
            }


        }
        return null;
    }


    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        map.put("hn","test1");
        map.put("hn","test2");

        System.out.println(map.get("hn"));

    }
}

