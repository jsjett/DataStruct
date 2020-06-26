package com.data.linkedList;

public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * 构造函数
     * @param data 节点的数据
     * @param next 下一个节点
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this(data, null);
    }

    public Node() {
        this(null, null);
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
