package cn.hn.MyCollection;

import java.util.Collection;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-12-4 下午11:15
 * @desc : TODO
 */
public class MyArrayList {


    Object[] value;


    int count;

    public MyArrayList(){
        this.value = new Object[16];
    }


    public MyArrayList(int size){
        this.value = new Object[size];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public int indexOf(Object o){
        return -1;
    }

    public void append(Object o){
        value[count] = o;
        count++;
        if (count >= value.length){
            int newCapacity = value.length * 2;
            Object[] newList = new Object[newCapacity];

            for (int i = 0; i <value.length ; i++) {
                newList[i] = this.value[i];
            }

            value = newList;

        }
    }

    public Object get(int index){
        if (index > count-1 || index < 0) throw new ArrayIndexOutOfBoundsException();

        return this.value[index];
    }

    public static void main(String[] args) {
        Collection c;
    }



}
