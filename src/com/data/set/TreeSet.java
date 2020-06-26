package com.data.set;

import com.data.tree.Tree;

/**
 * 使用二分搜索树实现一个集合
 * @param <T>
 */
public class TreeSet<T extends Comparable<T>> implements Set<T> {

    private final Tree<T> tree;

    public TreeSet() {
        this.tree = new Tree<>();
    }

    @Override
    public void add(T t) {
        if(!contains(t)) {
            tree.addElement(t);
        }
    }

    @Override
    public void remove(T t) {
        tree.removeElement(t);
    }

    @Override
    public boolean contains(T t) {
        return tree.contains(t);
    }

    @Override
    public int getSize() {
        return tree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return tree.getSize() == 0;
    }

    @Override
    public String toString() {
        return "TreeSet{" +
                "tree=" + tree +
                '}';
    }
}
