package com.jett.demo5;

import java.util.Iterator;

public class Template implements Iterator {

    public static void main(String[] args) {
//        Template template = new Template();
        int a = 111;
        Integer b = 222;
        System.out.println(a);
        System.out.println(b.toString());
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
