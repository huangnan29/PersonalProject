package cn.hn.DataStructs;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-10-15 上午11:01
 * @desc : TODO
 **/
public class TimeCompute {
    public static int maxSubSum1(int[] n){
        int maxSum = 0;

        for (int i = 0; i <n.length ; i++) {
            int thisSum = 0;

            for (int j = i; j <n.length ; j++) {
                thisSum += n[j];
                if (thisSum > maxSum);
                    maxSum = thisSum;
            }

        }

        return maxSum;
    }



    public static void main(String[] args) {
        int[] x = {1,-2,4,5,9,-4};
        int test = maxSubSum1(x);
        System.out.println(test);
        System.out.println();
        String matchString = "\\d{2}";
        Pattern pattern = Pattern.compile(matchString);




        String text = "03";
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.find());


    }
}
