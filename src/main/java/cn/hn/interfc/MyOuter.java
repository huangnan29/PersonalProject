package cn.hn.interfc;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-10 上午10:10
 **/
public class MyOuter {
    private int x = 100;

    class MyInner{
        private String y="Hello!";
        public void innerMethod(){
            System.out.println("内部类中 String ="+y);
            System.out.println("外部类中的x ="+x);
            outerMethod();
            System.out.println("x is "+MyOuter.this.x);
        }
    }

    public void outerMethod(){
        x++;
    }

    public void makeInner(){
        //在外部类方法中创建内部类实例
        MyInner in = new MyInner();
    }

    public MyInner getMyInnerObj(){
        return new MyInner();
    }

    public static void main(String[] args){
        MyOuter mo = new MyOuter();
        //使用外部类构造方法创建 mo 常规内部类需要通过外部类实例来new
        MyOuter.MyInner inner = mo.getMyInnerObj();
        inner.innerMethod();
    }
}
