package cn.hn.sort;

import java.util.LinkedList;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-11-7 下午10:33
 * @desc : TODO
 */
public class MergeSort {
    private static int[] b = {90, 12, 41, 33, 21, 52, 123, 31, 2, 1, 3};


    public static int[] sort(int[] a, int left, int right) {
        int mid = (left + right) / 2;
        //do splite
        if (left < right) {
            sort(a, 0, mid);
            sort(a, mid + 1, right);

            merge(a, left, mid, right);

        }
        return a;
    }

    public static int[] merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= right) {
            temp[k++] = a[j++];
        }

        for(int x=0;x<temp.length;x++){
            a[x+left] = temp[x];
        }
        return a;

    }

    



    public static void main(String[] args) {

        int[] x = MergeSort.sort(b, 0, 10);
        for (int i = 0; i <x.length ; i++) {
            System.out.println(x[i]);

        }
        LinkedList<Integer> list = new LinkedList<>();
    }



}
