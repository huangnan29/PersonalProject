package cn.hn.interfc;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-10 上午10:14
 **/
public class MyOuterStatic {
    public static int x=100;

    public static class Myinner{
        private String y="Hello!";
        /**
         * 由于static内部类不具有任何对外部类实例的引用，
         * 因此static内部类中不能使用this关键字来访问外部类中的实例成员，
         * 但是可以访问外部类中的static成员。这与一般类的static方法相通
         */
        public void innerMethod(){
            System.out.println("x="+x);
            System.out.println("y="+y);
        }
    }

    public static void main(String[] args){
        MyOuterStatic.Myinner si = new MyOuterStatic.Myinner();
        Myinner si2 = new Myinner();
        si.innerMethod();
        si2.innerMethod();
    }
}
