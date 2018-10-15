import cn.hn.DataStructs.Pair;
import cn.hn.Thread.Ricky;
import cn.hn.Thread.Student;
import cn.hn.Thread.Teacher;
import cn.hn.Thread.Tom;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.*;


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


    @Test
    public  int lengthOfLongestSubstring(){
        String s = "safasdfasdfasdf";
        if(s.length()==0){
            return 0;
        }
        int maxLength=1;
        List<Character> list=new ArrayList();
        list.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(list.contains(s.charAt(i))){
                int index=list.indexOf(s.charAt(i));
                list=list.subList(index+1, list.size());
                list.add(s.charAt(i));
                maxLength=Math.max(maxLength, list.size());
            }else{
                list.add(s.charAt(i));
                maxLength=Math.max(maxLength, list.size());
            }
        }
        return maxLength;
    }
}
