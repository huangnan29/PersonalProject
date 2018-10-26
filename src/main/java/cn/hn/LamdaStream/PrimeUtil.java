package cn.hn.LamdaStream;

import java.util.stream.IntStream;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-10-26 下午4:57
 * @desc : TODO
 **/
public class PrimeUtil {

    public static boolean isPrime(int num){
        int tmp = num;

        if (tmp<2){
            return false;
        }
        for (int i = 2; i <Math.sqrt(tmp) ; i++) {
            if (tmp % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int count = (int) IntStream.range(1,1000000).filter(PrimeUtil::isPrime).count();
        int count = (int) IntStream.range(1,1000000).parallel().filter(PrimeUtil::isPrime).count();
        System.out.println(count);
    }

}
