package com.data.struct;

public class MyStack<T> implements Stack<T> {

    private ArrayClass<T> array;

    public MyStack(int c) {
        this.array = new ArrayClass<>(c);
    }

    public MyStack() {
        this.array = new ArrayClass<>();
    }

    @Override
    public void push(T t) {
        this.array.addLast(t);
    }

    @Override
    public T pop() {
        return this.array.removeLast();
    }

    @Override
    public T peek() {
        return this.array.getLast();
    }

    @Override
    public int getSize() {
        return this.array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    public int getCapacity() {
        return this.array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Stack : ");
        str.append("[");
        for (int i = 0; i< array.getSize(); i++) {
            str.append(i);
            str.append(",");
        }
        str.append("]");
        str.append(" top");
        return str.toString();
    }
}
