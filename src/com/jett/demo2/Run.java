package com.jett.demo2;

public class Run {
    public static void main(String[] args) {
        Promise promise = new Promise();
        Promise promise1 = promise.then();
        promise1.cache();
    }
}
