package cn.hn.Demo;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-21 上午10:16
 * @desc : TODO 继承链中对象方法的调用的优先级：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)。
 **/
class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }

}

class B extends A{
    public String show(B obj){
        return ("B and B");
    }

    public String show(A obj){
        return ("B and A");
    }
}

class C extends B{

}

class D extends B{

}
//TODO 继承链中对象方法的调用的优先级：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)。
public class DemoClass {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println();

        System.out.println("1--" + a1.show(b));//TODO A.show(A) ->A and A
        System.out.println("2--" + a1.show(c));
        System.out.println("3--" + a1.show(d));//TODO A.show(D) -> A and D
        System.out.println("4--" + a2.show(b));//TODO  this.show(B) a2类型为A 不在调用范围 -> super.show(B)没有方法 ->this.show((super)B) ->B and A
        System.out.println("5--" + a2.show(c));//
        System.out.println("6--" + a2.show(d));//TODO A.show(D) -> A and D
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));
    }
}
