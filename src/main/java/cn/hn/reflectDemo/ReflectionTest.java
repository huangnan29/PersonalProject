package cn.hn.reflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @Author : huangnan
 * @Email : huangnan0729@gmail.com
 * @Date : 18-10-28 下午3:59
 * @desc : TODO
 */
public class ReflectionTest {
    public static void main(String[] args) {
//        Field

    }

    public static void printConstructors(Class cl){
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c:constructors) {
            String name = c.getName();
            System.out.println("    ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0 ) System.out.println(modifiers + " ");
            System.out.println(name + "(");

            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length ; j++) {
                if (j>0 ) System.out.println(", ");
                System.out.println(paramTypes[j].getName());

            }
            System.out.println(");");
        }

    }




}
