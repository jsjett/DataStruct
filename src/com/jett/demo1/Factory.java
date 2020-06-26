package com.jett.demo1;

import java.util.Arrays;

public class Factory {
    public static void main(String[] args) {
//        Dog dog = new Dog("xhangxiao",10);
//        Dog dog1 = new Dog("liujianfeng", 30);
//        dog.run();
//        dog1.run();
//
//        Dog dog2 = new Dog("shediao",0);
//        dog2.run();
//
//        System.out.println(Dog.FUCK_B);

//        Cat cat = new Cat("jett");
//        System.out.println(cat.getName());
//        System.out.println(Cat.BUY_COUNT_MAX);
//        System.out.println(Cat.isVip);
//        System.out.println(Math.random());

//        String name = new String("AaBaadfnjSJDBFJSDHdsnj");

//        System.out.println(name.length());
//        System.out.println(name.toLowerCase());
//        System.out.println(name.toUpperCase());
//        System.out.println(name.charAt(3));
//        System.out.println(name);
//        System.out.println(name.substring(2));
//        System.out.println(name);
//        System.out.println(name.substring(3,6));
//        System.out.println(name instanceof Object);
        String name = "apple_windows";
        String name2 = "apple_windows";
        String[] arr = name.split("");

        for (int i = 0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
        System.out.println(name.contains("Apple"));
        System.out.println(name.equals(name2));
    }
}
 