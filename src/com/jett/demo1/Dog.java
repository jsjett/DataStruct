package com.jett.demo1;

public class Dog {
    public static final int FUCK_B = 0;
    private String name;
    private Integer age;
    private Integer sex;
    private double price;


    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name,Integer age){
        this(name);
        this.age = age;
    }

    public void run() {
        System.out.println("小狗在跑");
    }
}
