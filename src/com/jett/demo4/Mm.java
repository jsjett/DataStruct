package com.jett.demo4;

public class Mm {
    public int count;

    public static String STATIC_ATTR = "hello world";

    public Mm(int c) {
        this.count = c;
    }

    public void sayHello() {
        System.out.println("i am instance say hello"+this.count);
    }

    public static void fuckBB() {
        System.out.println("i am is static fuck bb");
    }
}
