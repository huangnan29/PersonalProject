package cn.hn.designModel;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-10-25 下午10:55
 * @desc : TODO 饥饿模式实现
 */
public class SingletonOne {

    public SingletonOne() {
    }

    private static SingletonOne single = new SingletonOne();

    public static SingletonOne getInstance(){
        return single;
    }

    public static void main(String[] args) {

//        Disruptor

    }

}
