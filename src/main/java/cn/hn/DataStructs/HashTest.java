package cn.hn.DataStructs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-26 上午8:26
 * @desc : TODO
 **/


public class HashTest{
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int hashCode() {
        return i % 10;
    }

    /**
     * 以上这个示例，我们只是重写了hashCode方法，从上面的结果可以看出，虽然两个对象的hashCode相等，但是实际上两个对象并不是相等；
     * ，我们没有重写equals方法，那么就会调用object默认的equals方法，是比较两个对象的引用是不是相同，显示这是两个不同的对象，两个对象的引用肯定是不定的。
     * 这里我们将生成的对象放到了HashSet中，
     * 而HashSet中只能够存放唯一的对象，也就是相同的（适用于equals方法）的对象只会存放一个，但是这里实际上是两个对象a,b都被放到了HashSet中，这样HashSet就失去了他本身的意义了。
     * @param object
     * @return
     */

    public boolean equals(Object object) {  
        if (object == null) {  
            return false;  
        }  
        if (object == this) {  
            return true;  
        }  
        if (!(object instanceof HashTest)) {  
            return false;  
        }  
        HashTest other = (HashTest) object;  
        if (other.getI() == this.getI()) {  
            return true;  
        }  
        return false;  
    }

    public final static void main(String[] args) {
        HashTest a = new HashTest();
        HashTest b = new HashTest();
        a.setI(1);
        b.setI(1);
        Set<HashTest> set = new HashSet();
        set.add(a);
        set.add(b);
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(set);
    }
}
