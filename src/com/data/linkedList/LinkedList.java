package com.data.linkedList;

public class LinkedList<T> {

    private class Node {
        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this(data, null);
        }
    }

    // 链表头
    private Node dummyHead;
    // 链表的大小
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public void add(int index, T t) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("fail, the index is error");
        }

        Node prev = this.dummyHead;

        for (int i = 0; i< index; i++) {
            prev = prev.next;
        }

        Node node = new Node(t);

        node.next = prev.next;
        prev.next = node;
        size ++;

    }

    public void addFirst(T t) {
        add(0, t);
    }

    public void addLast(T t) {
        add(size -1, t);
    }

    /**
     * 删除链表中所有元素等于t 的节点
     * @param t 删除的元素的值
     */
    public void removeNodes(T t) {
        Node prev = this.dummyHead;
        Node retNode = null;
        while (prev.next != null) {
            if(prev.next.data.equals(t)) {
                retNode = prev.next;
                prev.next = retNode.next;
                retNode.next = null;
                size --;
            }else {
                prev = prev.next;
            }
        }
    }

    /**
     * 使用递归删除链表中所有元素等于t的节点
     * @param t 删除的元素的值
     */
    public void removeNodesWithDeep(T t) {
        removeNodesWithDeep(this.dummyHead, t);
    }

    private Node removeNodesWithDeep(Node head, T t) {
        // 如果head == null 说明已经到了链表的尾部
        if (head == null) {
            return null;
        }

        head.next = removeNodesWithDeep(head.next, t);
        // 如果当前节点的值等于t 则将当前节点的下一个节点返回 否则返回当前节点
        if(t.equals(head.data)) {
            size --;
            return head.next;
        }else {
            return head;
        }

    }

    public T remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove fail index is error");
        }

        Node prev = this.dummyHead;

        for (int i = 0; i< index; i++) {
            prev = prev.next;
        }

        // 即将删除的元素
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.data;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size -1 );
    }

    public void set(int index, T t) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("fail index is error");
        }

        Node current = this.dummyHead;

        for (int i = 0; i< index; i++) {
            current = current.next;
        }

        current = current.next;

        current.data = t;

    }

    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("fail index is error");
        }

        Node current = this.dummyHead.next;

        for (int i = 0; i< index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    public boolean contains(T t) {
        Node current = this.dummyHead;

        while (current != null) {
            if(t.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("LinkedList = { ");
        Node current = this.dummyHead.next;
        while (current != null) {
            str.append(current.data);
            str.append("->");
            current = current.next;
        }
        str.append("null } size = ");
        str.append(size);
        return str.toString();
    }
}