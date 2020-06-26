package com.jett.demo4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectAppMain {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Mm mm1 = new Mm(55);
        Class clazz = Mm.class;
        // 反射获取成员变量和静态变量
        Field field = clazz.getField("count");
        Field field1 = clazz.getField("STATIC_ATTR");

        System.out.println(field.get(mm1));

        System.out.println(field1.get(null));

        // 反射获取成员方法和静态方法并调用成员方法和静态方法
        Method sayHello = clazz.getMethod("sayHello");
        sayHello.invoke(mm1);
        // 静态方法
        Method fuckBB = clazz.getMethod("fuckBB");
        fuckBB.invoke(null);
    }

}
