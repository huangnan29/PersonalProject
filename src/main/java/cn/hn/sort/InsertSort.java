package cn.hn.sort;

import java.util.ArrayList;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-11-6 下午10:15
 * @desc : TODO
 */
public class InsertSort {

    /**
     * 插入排序
     */
    private static final int arrayLength = 20;

    private int[] a;

    public static int getArrayLength() {
        return arrayLength;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public void initArray() {
        int[] arr = new int[arrayLength];
        setA(arr);
    }


    /**
     * 1.遍历元素
     * 2.将index对应元素插入已排好序的序列.
     * 3.逻辑:找到对应的位置将index值插入,后排数组后移
     *
     * @param args
     */


    public static void main(String[] args) {


        int[] a = {90, 12, 41, 33, 21, 52, 123, 31, 2, 1, 3};
        int key;
        int j;
        for (int i = 0; i < a.length; i++) {
            key = a[i];
            j = i;
            while (j > 0 && a[j-1] > key) {
                a[j ] = a[j-1];
                j--;
            }
            a[j] = key;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        //
        int[] b = {90, 12, 41, 33, 21, 52, 123, 31, 2, 1, 3};
        int keyDesc;
        int n;
        for (int i = 0; i <b.length ; i++) {
            keyDesc = b[i];
            j = i;
            while (j>0 && b[j-1]<keyDesc){
                b[j] = b[j-1];
                j--;

            }
            b[j] = keyDesc;
        }

        for (int i = 0; i <b.length ; i++) {
            System.out.println(b[i]);
        }

    }

}
