package cn.hn.LamdaStream;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-10-26 下午3:47
 * @desc : TODO
 **/
public class TestStream {
    static int[] a = {1,2,3,4,5,6,7,8,9};
    public static void main(String[] args) {


//        Arrays.stream(a).map(x->(x%2==0)?x:x+1).forEach(System.out::println);
//        Arrays.stream(a).forEach(a->System.out.println(a));
        IntConsumer outprintln = System.out::println;
        IntConsumer errprintln = System.err::println;
        Arrays.stream(a).forEach(outprintln.andThen(errprintln));

    }

}
