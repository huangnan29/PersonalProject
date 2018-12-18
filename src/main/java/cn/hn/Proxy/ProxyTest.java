package cn.hn.Proxy;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-10-28 下午10:16
 * @desc : TODO
 */
public class ProxyTest {
    public static void main(String[] args) {
        LiuDeHuaProxy proxy = new LiuDeHuaProxy();

        Person p = proxy.getProxy();
        String retValue = p.sing("练习");

        System.out.println(retValue);

        String value = p.dance("江南style");
        System.out.println(value);

    }
}
