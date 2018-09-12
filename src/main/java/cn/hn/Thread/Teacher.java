package cn.hn.Thread;

import java.util.ArrayList;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-7 上午9:57
 **/
public class Teacher implements Callback {

    private ArrayList<Student> student;

    public Teacher(ArrayList<Student> student) {
        this.student = student;
    }

    public void askQuestion() {
        for(Student stu : student){
            stu.resolveQuestion(this);
        }


    }

    public void tellAnswer(int answer,String name) {
        System.out.println("知道了，"+name+"的答案是" + answer);
    }


}
