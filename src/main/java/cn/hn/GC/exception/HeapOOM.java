package cn.hn.GC.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-12-3 上午9:07
 * @desc : TODO
 **/
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        int count = 0;
        while (true) {
            list.add(new OOMObject());
            System.out.println(count++);
        }

    }

}
