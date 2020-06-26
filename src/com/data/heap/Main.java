package com.data.heap;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        int n = 10;
        Random random = new Random();
        for (int i = 0; i< n; i++) {
            int s = random.nextInt(n);
            System.out.println(s);
            maxHeap.add(s);
        }

        System.out.println("----->");

        System.out.println(maxHeap.size());

        System.out.println("----->");

        int[] res = new int[n];
        for (int i = 0; i< n; i++) {
            res[i] = maxHeap.extractMax();
        }

        for (int i = 0; i< res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
