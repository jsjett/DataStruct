package com.data.map;

/**
 * map 接口
 * @param <K> 键
 * @param <V> 值
 */
public interface Map<K, V> {
    void add(K k,V v);
    V remove(K k);
    boolean contains(K k);
    V get(K k);
    void set(K k,V v);
    int getSize();
    boolean isEmpty();
}
