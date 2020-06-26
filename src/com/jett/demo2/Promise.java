package com.jett.demo2;

/**
 * 实现一个异步处理类
 */
public class Promise {
    private int[] arr;
    private byte status;

    public Promise then() {
        return new Promise();
    }

    public Promise cache() {
        return new Promise();
    }

    public static Promise resolve() {
        return new Promise();
    }

    public static Promise reject() {
        return new Promise();
    }
}
