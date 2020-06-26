package com.data.segmentTree;

public interface SegmentTree<T> {
    int size();
    boolean isEmpty();

    T query(int a, int b);

    void update(int index, T value);
}
