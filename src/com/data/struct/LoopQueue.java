package com.data.struct;


public class LoopQueue<T> implements Queue<T> {

    // 数组
    private T[] data;
    // 对首指针
    private int front;
    // 对尾指针
    private int tail;
    // 当前队列的元素个数
    private int size;

    /**
     * @param capacity 队列的容量
     */

    public LoopQueue(int capacity) {
        data = (T[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 元素进入队列
     * @param e 入队的元素
     */
    @Override
    public void enqueue(T e) {
        // 当数组都装满的时候 对数组进行扩容
        if((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;

    }

    /**
     * 对数组进行扩容
     * @param capacity 容量
     */
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity + 1];

        for (int i = 0; i< size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 获取当前队列的容量
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 出队列
     * @return E
     */
    @Override
    public T dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("空队列不能出队操作");
        }
        T item = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() /4  && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return item;
    }

    @Override
    public T getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queu is empyt");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {StringBuilder res = new StringBuilder();

        StringBuilder string = new StringBuilder();
        string.append("LoopQueue = {");
        string.append("data = [");
        for (int i = front; i!= tail; i = (i + 1) % data.length) {
            string.append(data[i]);
            string.append(",");
        }

        string.append("] , size = ");
        string.append(size);
        string.append(", front = ");
        string.append(front);
        string.append(", tail = ");
        string.append(tail);
        string.append(", capacity = ");
        string.append(getCapacity());
        string.append("}");
        return string.toString();
    }
}
