package com.data.struct;

public class RunInContext {
    public static void main(String[] args) {

        LoopQueue<Integer> loopQueue = new LoopQueue<>(5);
        double time1 = System.nanoTime();
        for (int i = 0; i< 100000; i++) {
            loopQueue.enqueue(i);
        }

        for (int i = 0; i< 100000 - 1; i++) {
            loopQueue.dequeue();
        }

        double time2 = System.nanoTime();

        System.out.println((time2 - time1) / 1000000000);
        System.out.println(loopQueue);
    }
}
