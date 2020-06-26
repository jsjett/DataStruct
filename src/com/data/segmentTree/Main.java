package com.data.segmentTree;

/**
 * 线段树
 */
public class Main {
    public static void main(String[] args) {
        Integer[] ints = {4,2,3,6,1};

        MySegmentTree<Integer> mySegmentTree = new MySegmentTree<>(ints, new Merger<Integer>() {

            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });

        System.out.println(mySegmentTree);

        mySegmentTree.update(1,4);

        System.out.println(mySegmentTree);

//        System.out.println(mySegmentTree.query(0,4));
    }
}
