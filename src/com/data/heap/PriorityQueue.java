package com.data.heap;

import com.data.struct.Queue;

/**
 * 基于最大堆实现的优先队列
 * @param <T>
 */
public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {

    private MaxHeap<T> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    // 入队
    @Override
    public void enqueue(T e) {
        maxHeap.add(e);
    }

    // 出队
    @Override
    public T dequeue() {
        return maxHeap.extractMax();
    }

    // 查看对首元素
    @Override
    public T getFront() {
        return maxHeap.findMax();
    }

    // 获取队列的size
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    // 查看队列是否为空
    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
