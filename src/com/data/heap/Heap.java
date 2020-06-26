package com.data.heap;

/**
 * 堆的接口
 * @param <T>
 */
public interface Heap<T extends Comparable<T>> {
    // 容量
    int getCapacity();

    boolean isEmpty();

    int size();

    void add(T t);

    T findMax();

    // 取出最大的元素
    T extractMax();

}
