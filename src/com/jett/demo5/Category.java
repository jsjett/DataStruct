package com.jett.demo5;

public enum Category {

    TM(1),
    VIP(2),
    TB(3),
    JD(4);

    private int id;

    Category(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                '}';
    }
}
