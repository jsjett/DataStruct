package com.data.union;

public interface UF {
    // 检查两个元素是否连接
    boolean isConnected(int p, int q);
    // 将两个元素并在一起
    void unionElements(int p, int q);
    int getSize();
    boolean isEmpty();
}
