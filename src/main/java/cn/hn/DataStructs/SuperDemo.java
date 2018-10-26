package cn.hn.DataStructs;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-10-25 上午10:07
 * @desc : TODO
 **/
public class SuperDemo extends ClassSomething {


    public  String testNext(){
        return "son";
    }

    public void printString(){
        System.out.println(super.testNext());
        System.out.println(this.testNext());
    }

    public static void main(String[] args) {
        SuperDemo sd = new SuperDemo();

        sd.printString();


    }

}
