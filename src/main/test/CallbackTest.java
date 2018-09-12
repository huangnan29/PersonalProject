import cn.hn.Thread.Ricky;
import cn.hn.Thread.Student;
import cn.hn.Thread.Teacher;
import cn.hn.Thread.Tom;
import org.junit.Test;

import java.util.ArrayList;


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

}
