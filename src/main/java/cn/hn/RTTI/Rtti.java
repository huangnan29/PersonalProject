package cn.hn.RTTI;



public class Rtti {
    public static void main(String[] args) throws ClassNotFoundException {
        Human aPerson = new Human();
        Class c1      = aPerson.getClass();
        System.out.println(c1.getName());
        System.out.println(c1.getPackage());
        Human anotherPerson = new Woman();
        Class c2      = anotherPerson.getClass();
        System.out.println(c2.getName());
        Class c3      = Class.forName("cn.hn.RTTI.Human");
        System.out.println(c1.getName());

        Class c4      = Woman.class;
        System.out.println(c2.getName());


        System.out.println(aPerson.name);


        System.out.println("__________________________");
        B b = new B();
        A a = new A();
        A ba = new B();
        System.out.println("1------------");
        System.out.println(b instanceof B);
        System.out.println(b instanceof A);
        System.out.println(b instanceof Object);
        System.out.println(null instanceof Object);
        System.out.println("2------------");
        System.out.println(b.getClass().isInstance(b));
        System.out.println(b.getClass().isInstance(a));
        System.out.println("3------------");
        System.out.println(a.getClass().isInstance(ba));
        System.out.println(b.getClass().isInstance(ba));
        System.out.println(b.getClass().isInstance(null));
        System.out.println("4------------");
        System.out.println(A.class.isInstance(a));
        System.out.println(A.class.isInstance(b));
        System.out.println(A.class.isInstance(ba));
        System.out.println("5------------");
        System.out.println(B.class.isInstance(a));
        System.out.println(B.class.isInstance(b));
        System.out.println(B.class.isInstance(ba));
        System.out.println("6------------");
        System.out.println(Object.class.isInstance(b));
        System.out.println(Object.class.isInstance(null));
    }
};

class Human
{
    public static String name = "hnhn";
    private int height;
    /**
     * accessor
     */
    public int getHeight()
    {
        return this.height;
    }

    /**
     * mutator
     */
    public void growHeight(int h)
    {
        this.height = this.height + h;
    }


    static {
        System.out.println("hn的静态块");
    }
}

class Woman extends Human
{
    /**
     * new method
     */
    public Human giveBirth()
    {
        System.out.println("Give birth");
        return (new Human());
    }

}

class A {
}

class B extends A {
}