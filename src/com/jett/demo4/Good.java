package com.jett.demo4;

class Good {

    private String name;
    private double price;

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int buy() {
        System.out.println("只能购买2件商品");
        return 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    protected void fuckFamily() {

    }
}
