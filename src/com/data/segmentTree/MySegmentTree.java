package com.data.segmentTree;

/**
 * 线段树
 *
 * @param <T>
 */
public class MySegmentTree<T> implements SegmentTree<T> {
    private Merger<T> merger;
    private T[] tree;
    private T[] data;

    public MySegmentTree(T[] res, Merger merger) {
        this.merger = merger;
        this.data = (T[]) new Object[res.length];
        for (int i = 0; i < res.length; i++) {
            data[i] = res[i];
        }
        this.tree = (T[]) new Object[4 * res.length];
        buildSegmentTree(0, 0, res.length - 1);
    }

    /**
     * 构建线段树
     */
    private void buildSegmentTree(int treeIndex, int left, int right) {
        // 当左边索引和右边索引相等的时候 说名线段树不能在被划分
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }

        // 获取到当前treeIndex的左孩子的索引
        int leftTreeIndex = leftChild(treeIndex);
        // 获取到当前treeIndex的右孩子的索引
        int rightTreeIndex = rightChild(treeIndex);
        // 获取到左右孩子的中间索引
        int middle = left + (right - left) / 2;

        buildSegmentTree(leftTreeIndex, left, middle);
        buildSegmentTree(rightTreeIndex, middle + 1, right);

        // 当递归构建完子树后
        tree[treeIndex] = this.merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return data.length == 0;
    }

    /**
     * 查询 区间 [a,b] 之间的值
     *
     * @param queryL 左边界
     * @param queryR 右边界
     * @return merge的值
     */
    @Override
    public T query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR > data.length ||
                queryL > queryR
        ) {
            throw new IllegalArgumentException("index is error");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 更新
     *
     * @param index 更新的索引
     * @param value 更新的值
     */
    @Override
    public void update(int index, T value) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("the index is error");
        }
        // 更新data
        data[index] = value;
        // 更新线段树
        update(0, 0, data.length - 1, index, value);
    }

    /**
     * 更新data数组索引为updateIndex的值
     * @param treeIndex 当前节点
     * @param left 左边界
     * @param right 右边界
     * @param updateIndex 更新的索引
     * @param value 更新的值
     */
    private void update(int treeIndex, int left, int right, int updateIndex, T value) {
        if (left == right && left == updateIndex) {
            tree[treeIndex] = value;
            return;
        }

        int middle = left + (right - left) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        // 说明在左区间
        if(updateIndex >= left && updateIndex <= middle) {
            update(leftTreeIndex, left, middle, updateIndex, value);
        }else if(updateIndex >= middle+1 && updateIndex <= right) {
            // 说明在右区间
            update(rightTreeIndex, middle + 1, right, updateIndex, value);
        }

        // 当当前treeIndex 的左右或者右孩子更新了值的时候 需要更新当前treeIndex的值
        tree[treeIndex] = this.merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    /**
     * 返回区间内的值
     *
     * @param treeIndex 当前节点
     * @param left      左边界
     * @param right     右边界
     * @param queryL    查询的左区间
     * @param queryR    查询的右区间
     * @return 查询到的merge的值
     */
    private T query(int treeIndex, int left, int right, int queryL, int queryR) {
        // 当左边界等于查询的左区间  右边界等于查询的右区间 说明找到的所查找的区间
        if (left == queryL && right == queryR) {
            return tree[treeIndex];
        }

        int middle = left + (right - left) / 2;
        int rightTreeIndex = rightChild(treeIndex);
        int leftTreeIndex = leftChild(treeIndex);
        // 如果queryL 大于等于middle+1 说明落在右区间
        if (queryL >= middle + 1) {
            return query(rightTreeIndex, middle + 1, right, queryL, queryR);
        } else if (queryR <= middle) {
            // 如果queryR 小于等于middle 说明落在左区间
            return query(leftTreeIndex, left, middle, queryL, queryR);
        } else {
            // 如果所查找的区间在当前左边和右边横跨的时候
            T leftResult = query(leftTreeIndex, left, middle, queryL, middle);
            T rightResult = query(rightTreeIndex, middle + 1, right, middle + 1, queryR);
            return this.merger.merge(leftResult, rightResult);
        }
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("MySegmentTree{");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == null) {
                string.append("null");
            } else {
                string.append(tree[i]);
            }
            if (i != tree.length - 1) {
                string.append(",");
            }
        }
        string.append("}");
        return string.toString();
    }
}
