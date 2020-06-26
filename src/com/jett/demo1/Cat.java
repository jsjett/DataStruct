package com.jett.demo1;

public class Cat extends Animal {

    private String name;

    public static int BUY_COUNT_MAX = 1;
    public static boolean isVip = false;

    public Cat(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEat() {
        return "c";
    }
}
