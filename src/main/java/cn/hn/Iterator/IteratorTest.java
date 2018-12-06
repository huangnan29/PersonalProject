package cn.hn.Iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-12-6 上午8:26
 * @desc : TODO
 **/
public class IteratorTest {

    public static void main(String[] args) {
        Set set = new HashSet();

        set.add("111");
        set.add("112");
        set.add("113");
        set.add("114");

        Iterator iter = set.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        for (Iterator iter2 = set.iterator();iter2.hasNext();){
            System.out.println(iter2.next());
        }


    }


}
