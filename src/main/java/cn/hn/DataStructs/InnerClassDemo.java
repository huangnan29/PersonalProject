package cn.hn.DataStructs;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-10-28 下午6:59
 * @desc : TODO
 */
public class InnerClassDemo {

    private int numA = 10;

    class Inner{
        int numA =15;
        public void printParam(){
            System.out.println(numA);

            System.out.println(InnerClassDemo.this.numA);
        }
    }

    static class InnerStatic{
        int numB = 30;
    }

    public static void main(String[] args) {
        InnerClassDemo icd = new InnerClassDemo();

        InnerClassDemo.Inner inner = icd.new Inner();

        InnerStatic innerStatic = new InnerStatic();
        System.out.println(innerStatic.numB);
        inner.printParam();

    }

}
