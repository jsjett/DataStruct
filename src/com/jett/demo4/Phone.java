package com.jett.demo4;

import com.jett.demo3.MainLesson;
import sun.rmi.rmic.Main;

public class Phone extends Good {

    public static void main(String[] args) {
        Phone p = new Phone("华为", 3000L);
        System.out.println(p.getName());
        System.out.println(p.getPrice());
        int buyNum = p.buy();
        System.out.println(buyNum);
        p.saySb();
    }

    public Phone(String name, double price) {
        super(name, price);
    }

    @Override
    public int buy() {
        System.out.println("phone de buy fangfa");
        return 3;
    }

    public void saySb() {
        System.out.println("这个老师是傻屌");
    }

}
