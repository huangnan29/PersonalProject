package cn.hn.DataStructs.Queue;

import javax.xml.bind.annotation.XmlType;
import java.util.*;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-10-16 下午12:13
 * @desc : TODO
 **/
public class ArrayQueue {
    private static final int DEFAULT_SIZE = 10;

    private int[] mArray;
    private int mCount;

    public ArrayQueue(int size){
        mArray = new int[size];
        mCount = 0;
    }

    public ArrayQueue(){
        this(DEFAULT_SIZE);
    }

    public void add(int val){
        mArray[mCount++] = val;
    }

    public int front(){
        return mArray[mCount-1];
    }

    public int pop(){
        int tmp;
        tmp = front();
        mCount--;
        for (int i = 1; i <=mCount ; i++) {
            mArray[i-1] = mArray[i];
        }
        return tmp;
    }

    public int size(){
        return mCount;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public static void main(String[] args) {
        int tmp=0;
        ArrayQueue astack = new ArrayQueue(12);
                // 将10, 20, 30 依次推入栈中
        astack.add(10);
        astack.add(20);
        astack.add(30);
                // 将“栈顶元素”赋值给tmp，并删除“栈顶元素”
        tmp = astack.pop();
        System.out.printf("tmp=%d\n", tmp);
                // 只将“栈顶”赋值给tmp，不删除该元素.
        tmp = astack.front();
        System.out.printf("tmp=%d\n", tmp);
                astack.add(40);
                System.out.printf("isEmpty()=%b\n", astack.isEmpty());
        System.out.printf("size()=%d\n", astack.size());
        while (!astack.isEmpty()) {
                 System.out.printf("size()=%d\n", astack.pop());
        }
        ArrayList<String> test = new ArrayList<>();
        Map<String,String> map = new HashMap<String, String>() ;
//        Queue
    }

}
