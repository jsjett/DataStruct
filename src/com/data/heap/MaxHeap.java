package com.data.heap;

import com.data.struct.ArrayClass;

/**
 * 最大堆
 *
 * @param <T> 数据
 */
public class MaxHeap<T extends Comparable<T>> implements Heap<T> {

    private final ArrayClass<T> data;


    public MaxHeap() {
        data = new ArrayClass<T>();
    }

    /**
     * 添加元素
     *
     * @param t 添加的元素
     */
    @Override
    public void add(T t) {
        data.addLast(t);
        siftUp(data.getSize() - 1);
    }

    /**
     * 取出最大堆的最大的元素 其他的元素进行重新排序
     *
     * @return 最大的元素
     */
    @Override
    public T extractMax() {
        if (data.getSize() == 0) {
            return null;
        }
        // 首先将最后一个元素和第一个交换元素 然后拿到最后一个返回 在将第一个下沉
        data.swap(0, data.getSize() - 1);
        T result = data.removeLast();
        siftDown(0);
        return result;
    }


    /**
     * 查看最大的元素
     *
     * @return 最大的元素  也就是最大堆的堆顶元素
     */
    @Override
    public T findMax() {
        if (data.getSize() == 0) {
            return null;
        }
        return data.get(0);
    }

    /**
     * 上浮元素
     *
     * @param index 需要上浮的元素的索引
     */
    private void siftUp(int index) {
        // 当索引小于0 并且当前index位置的元素比他的父元素大的时候就进行循环
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            // 交换当前index的元素和父元素
            data.swap(index, parent(index));
            // 将当前index更新到父索引
            index = parent(index);
        }
    }

    /**
     * 下浮元素
     *
     * @param index 需要下浮的元素的索引
     */
    private void siftDown(int index) {
        // 当index位置的节点的左孩子的索引比当前data的size小 说明存在左孩子
        // 反之  如果左孩子的索引大于data.size 说明没有左孩子  当前节点是叶子节点
        while (leftChild(index) < data.getSize()) {
            int j = leftChild(index);
            // 如果右孩子的索引小于data的大小 说明右孩子存在 并且比较左孩子和右孩子的大小
            // 如果右孩子比左孩子大  则将j更新到右孩子的索引 保证j指向的是最大的孩子的索引
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(index);
            }
            // 如果当前index节点大于等于j 则不需要下沉
            if(data.get(index).compareTo(data.get(j)) >= 0) {
                break;
            }
            // 交换当前节点和最大的值 并且更新index为交换过后的节点的索引
            data.swap(index, j);
            index = j;
        }
    }

    /**
     * 返回索引为index的父节点的索引
     *
     * @param index 索引
     * @return 父索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index -> 0 is not parent");
        }

        return (index - 1) / 2;
    }

    /**
     * 返回索引为index的节点的左孩子的索引
     *
     * @param index 索引
     * @return 左孩子的索引
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回索引为index的节点的右孩子的索引
     *
     * @param index 索引
     * @return 右孩子的索引
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public int getCapacity() {
        return data.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.getSize();
    }
}
