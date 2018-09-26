package cn.hn.DataStructs;

import java.util.Random;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-26 下午3:16
 * @desc : TODO
 **/
public class NumGenerator implements Generator<Integer> {

    int[] ages = {18,24,31};

    @Override
    public Integer text() {
        Random random = new Random();
        return ages[random.nextInt(3)];
    }

    public static void main(String[] args) {
        NumGenerator age = new NumGenerator();
        for (int i = 0; i <10 ; i++) {
            System.out.println(age.text());
        }

    }
}
