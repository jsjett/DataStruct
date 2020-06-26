package com.jett.demo5;

import java.util.Date;

public class Product implements ExpireDate {

    public static void main(String[] args) {
        Product product = new Product();
        System.out.println(product);
        product.noExp(new Date());
        String str = product.getYourName();
        System.out.println(str);
    }

    @Override
    public boolean noExp(Date time) {
        return false;
    }
}
