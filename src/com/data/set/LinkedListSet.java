package com.data.set;

import com.data.linkedList.LinkedList;

public class LinkedListSet<T> implements Set<T>{
    private final LinkedList<T> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(T t) {
        if(!contains(t)) {
            list.addFirst(t);
        }
    }

    @Override
    public void remove(T t) {
        list.removeNodes(t);
    }

    @Override
    public boolean contains(T t) {
        return list.contains(t);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "LinkedListSet{" +
                "list=" + list +
                '}';
    }
}
