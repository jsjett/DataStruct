package com.data.union;

/**
 * 并查集
 */
public class MyUF implements UF {
    @Override
    public boolean isConnected(int p, int q) {
        return false;
    }

    @Override
    public void unionElements(int p, int q) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
