package cn.hn.arithmetic;

import java.util.*;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-10-13 下午10:10
 * @desc : TODO
 */
public class ArrayCompute {
    private int SUM = 27;

    class PairSum {
        int forward;
        int backward;

        PairSum(int start,int end){
            this.forward = start;
            this.forward = end;

        }

        public int getForward() {
            return forward;
        }

        public void setForward(int forward) {
            this.forward = forward;
        }

        public int getBackward() {
            return backward;
        }

        public void setBackward(int backward) {
            this.backward = backward;
        }
    }

    public ArrayList<PairSum> getArrPairSum(int[] arr) {
        ArrayList<PairSum> pair = new ArrayList<PairSum>();
        int end = arr.length - 1;
        int start = 0;
        while (start < end){
            if (SUM ==  (arr[start]+ arr[end]) ) {
                pair.add(new PairSum(start,end));
                System.out.println("start:"+start+" end:"+end);
                start++;
                end--;
            }
            else if ( SUM <  (arr[start]+ arr[end])) end --;
            else start++;
        }

        return pair;
    }

    public static void main(String[] args) {
        ArrayCompute ac = new ArrayCompute();

        int[] arr = {1, 2, 3, 5, 7, 8, 11, 13, 14, 19, 24, 25};
        Hashtable<String,String> testHT = new Hashtable<String, String>();

        HashMap<String,String> testHM = new HashMap<String, String>();

        ArrayList<PairSum> res  = ac.getArrPairSum(arr);

        LinkedList<String> testLL = new LinkedList<String>();

        LinkedHashMap<String,String> testLHM = new LinkedHashMap<String, String>();



    }

}
