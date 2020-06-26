package com.jett.demo4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectStudy {

    public static void dyncArg(int a, int... arg) {
        System.out.println(a);
        for (int z : arg) {
            System.out.println(z);
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {
        dyncArg(1,2,3,4,4,5,6);
//        Pc pc = new Pc("sss","ccc");
        Pc pc1 = new Pc("sss","ccc");
        Class clazz = pc1.getClass();
        Field field = clazz.getField("fuckWhat");
        System.out.println(field.getName());

//        Method equ =  clazz.getMethod("equals", Object.class);
//        System.out.println(pc1.equals(pc));
//        ObjectStudy.printObj(pc);
//        String str = "aaabbb";
//        String str2 = "aaa"+"bbb";
//        System.out.println(str == str2.toString());
//        System.out.println(str.equals(str2));

    }

    public static void printObj(Object obj) {
        System.out.println(obj);
        System.out.println(obj.toString());
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getName());
        System.out.println(obj.hashCode());
    }
}
