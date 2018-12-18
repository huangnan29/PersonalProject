package cn.hn.MyCollection;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-12-5 下午9:37
 * @desc : TODO  自己实现HashMap
 */
public class MyMap {

    MyEntry[] arr  = new MyEntry[999];

    int size;

    /**
     * 注意键不能重复
     * @param key
     * @param value
     */

    public void put(Object key,Object value){
        MyEntry me = new MyEntry(key,value);
        //解决键已经存在的问题
        for (int i = 0; i <size ; i++) {
            if (arr[i].key.equals(key)){
                arr[i].value = value;
                return;
            }
        }
        arr[size++] = me;
    }

    public Object get (Object key){
        for (int i = 0; i <size ; i++) {
            if (arr[i].key.equals(key)){
                return arr[i].value;
            }
        }
        return null;
    }

    public boolean containsKey(Object key){
        for (int i = 0; i <size ; i++) {
            if (arr[i].key.equals(key)){
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object value){
        for (int i = 0; i <size ; i++) {
            if (arr[i].value.equals(value)){
                return true;
            }
        }
        return false;
    }

    public void remove(Object key){


        for (int i = 0; i <size ; i++) {
            if (arr[i].key.equals(key)){
                for (int j = i; j <size-1 ; j++) {
                    arr[j] = arr[j+1];
                }
                arr[size-1] = null;
                size--;
            }
        }

        System.out.println("不包含key");

    }


    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        MyMap myHashMap = new MyMap();
        myHashMap.put("hn1","test1");
        myHashMap.put("hn2","test2");
        myHashMap.put("hn3","test3");
        myHashMap.remove("hn1");
        System.out.println(myHashMap.get("hn1"));


    }
}


