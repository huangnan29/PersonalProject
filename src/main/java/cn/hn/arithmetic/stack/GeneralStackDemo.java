package cn.hn.arithmetic.stack;

import java.lang.reflect.Array;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-10-15 下午11:26
 * @desc : TODO
 */
public class GeneralStackDemo<T> {
    private static final int DEFAULT_SIZE = 10;
    private T[] stackArray;
    private int count;

    public GeneralStackDemo(Class<T> type){
        this(type,DEFAULT_SIZE);
    }


    public GeneralStackDemo(Class<T> type, int size) {
        stackArray = (T[]) Array.newInstance(type,size);
        count = 0;
    }

    public void push(T val){
        stackArray[count++] = val;
    }

    public T peek (){
        return stackArray[count-1];
    }

    public T pop(){
        T poplast = stackArray[count-1];
//        this.remove(count-1);
        count--;
        return poplast;
    }

    public  int size(){
        return count;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void pritnStackElement(){
        if (isEmpty()){
            System.out.println("stack is empty");
        }

        System.out.printf("stack size()=%d\n",size());
//        System.out.printf("stack size()=%d\n", size());
        for (int i = 0; i < size() ; i++) {
            System.out.println(stackArray[i]);
        }

    }

    public static void main(String[] args) {
        GeneralStackDemo<String> gs = new GeneralStackDemo<String>(String.class);
        gs.push("test1");
        gs.push("test2");
        gs.push("test3");
        gs.push("test4");

        String tmp;
        tmp = gs.peek();
        System.out.println(gs.peek());

        System.out.println(gs.pop());

        gs.pritnStackElement();



    }

}
