package cn.hn.RTTI;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz1 = Base.class;
        System.out.println("-----");
        Class clazz2 = Class.forName("cn.hn.RTTI.Base");


        System.out.println(clazz1.getName());
        System.out.println(clazz2.getName());
    }
}
