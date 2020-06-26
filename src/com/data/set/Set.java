package com.data.set;

/**
 * 集合类的接口
 * @param <T>
 */
public interface Set<T> {
    void add(T t);
    void remove(T t);
    boolean contains(T t);
    int getSize();
    boolean isEmpty();
}
