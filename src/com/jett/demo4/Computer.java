package com.jett.demo4;

import java.util.Objects;

public class Computer {
    private String head;
    private String body;

    public static String staticAttr;

    public Computer(String head, String body) {
        this.head = head;
        this.body = body;
    }

    public static void staticMethod() {
        System.out.println("static method in computer");
    }


    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;
        Computer computer = (Computer) o;
        return getHead().equals(computer.getHead()) &&
                getBody().equals(computer.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHead(), getBody());
    }
}
