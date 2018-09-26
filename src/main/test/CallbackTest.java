import cn.hn.DataStructs.Pair;
import cn.hn.Thread.Ricky;
import cn.hn.Thread.Student;
import cn.hn.Thread.Teacher;
import cn.hn.Thread.Tom;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-7 上午10:00
 **/
public class CallbackTest {

    @Test
    public void testCallback() {
        ArrayList<Student> stu = new ArrayList<Student>();
        Student student1 = new Ricky();
        Student student2 = new Tom();
        stu.add(student1);
        stu.add(student2);

        Teacher teacher = new Teacher(stu);

        teacher.askQuestion();

    }


    @Test
    public void testSimboling() {
        System.out.println(1 << 2);
        System.out.println(1 << 10);
//        System.out.println(2 << 2);
//        System.out.println(2 << );
        System.out.printf("");
        System.out.println("CallbackTest.testSimboling");
        System.out.println("");
        System.out.println("true = " + true);
        Collection<String> tst = new HashSet<String>();
        tst.add("test");
        tst.add("tes1t");
        System.out.println(tst.iterator().next());
    }

    @Test
    public void testT() {
        Pair<String> pair = new Pair<String>("test1", "test2");
        Pair<Integer> pair1 = new Pair<Integer>(1, 2);
        System.out.println(pair.getFirst() + " & " + pair.getSecond());
        System.out.println(pair1.getFirst() + pair1.getSecond());

        ArrayList a = new ArrayList();
        a.add("aaa");
        String test = (String) a.get(0);

        ArrayList<String> testString = new ArrayList();
        testString.add("bbb");
        String test2 = testString.get(0);
    }
}
