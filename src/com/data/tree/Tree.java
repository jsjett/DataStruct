package com.data.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 *
 * @param <T> 实现了Comparable接口的数据类型
 */
public class Tree<T extends Comparable<T>> {

    private class Node {
        public T value;
        public Node left;
        public Node right;

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private int size;
    private Node root;

    public Tree() {
        this.size = 0;
        this.root = null;
    }

    public boolean isEmpty() {
        return size ==0;
    }

    public int getSize() {
        return size;
    }

    private void updateSize(){
        size ++;
    }
    /**
     * 向树中添加一个元素
     *
     * @param value 元素的值
     */
    public void addElement(T value) {
        root = addElement(root, value);
    }

    private Node addElement(Node node, T value) {

        if(node == null) {
            updateSize();
            return new Node(value);
        }
        // 当前值比node小 插入到node的左边
        if(value.compareTo(node.value) < 0) {
            node.left = addElement(node.left, value);
        }else if(value.compareTo(node.value) > 0) {
            // 当前的值比node大 插入到node的右边
            node.right = addElement(node.right, value);
        }
        return node;
    }

    public boolean contains(T value) {

        return hasValue(root, value);
    }

    private boolean hasValue(Node node, T value) {
        if(node == null) {
            return false;
        }

        if(value.equals(node.value)) {
            return true;
        }else if(value.compareTo(node.value) < 0) {
            return hasValue(node.left, value);
        }else {
            return hasValue(node.right, value);
        }
    }

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 使用非递归的方式 前序遍历
    public void preOrderStack() {
        preOrderStack(root);
    }

    /**
     * 前序遍历的非递归实现
     * @param node
     */
    private void preOrderStack(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.value);
            if(current.right != null) {
                stack.push(current.right);
            }
            if(current.left != null) {
                stack.push(current.left);
            }
        }
    }

    /**
     * 使用队列进行层序遍历
     */
    public void levelTraversal() {
        levelTraversal(root);
    }

    /**
     * 层序遍历的实现
     * @param node
     */
    private void levelTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current.value);
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }

    /**
     * 获取最小值
     * @return
     */
    public T getMinValue() {
        return getMinNode(root).value;
    }

    /**
     * 获取最大值
     * @return
     */
    public T getMaxValue() {
        return getMaxNode(root).value;
    }

    /**
     * 获取最大值的node
     * @return
     */
    private Node getMaxNode(Node node) {

        if(node.right == null) {
            return node;
        }

        return getMaxNode(node.right);
    }

    /**
     * 获取最小的node
     * @return 返回最小的node
     */
    private Node getMinNode(Node node) {
        if(node.left == null) {
            return node;
        }
        return getMinNode(node.left);
    }

    /**
     * 删除二分搜索树的最小值 并且返回删除的最小node的value
     * @return
     */
    public T removeMin() {
        T ret = getMinValue();
        removeMinNode(root);
        return ret;
    }

    /**
     * 删除最小node的实现
     * @param node
     * @return
     */
    private Node removeMinNode(Node node) {
        if(node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMinNode(node.left);
        return node;
    }

    /**
     * 删除二分搜索树的最大值
     * @return
     */

    public T removeMax() {
        T ret = getMaxValue();
        removeMaxNode(root);
        return ret;
    }

    /**
     * 删除最大的node
     * @return
     */
    private Node removeMaxNode(Node node) {
        if(node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMaxNode(node.right);
        return node;
    }

    /**
     * 删除任意的node
     * @return 返回的是新生成的几点的根元素
     */
    public void removeElement(T value) {
        root = removeElement(root, value);
    }

    /**
     * 删除任意一个节点的实现
     * @param node
     * @param value
     * @return
     */
    private Node removeElement(Node node, T value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.value) < 0) {
            node.left = removeElement(node.left, value);
            return node;
        } else if (value.compareTo(node.value) > 0) {
            node.right = removeElement(node.right, value);
            return node;
        } else {
            // 当 node的value 和当前要删除的value相等的时候
            // 如果当前node的左节点为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 如果当前Node的右节点为空
            else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                // 当左节点和右节点同时存在
                // 首先找到右侧最小的node
                Node current = getMinNode(node.right);
                // 然后将右侧最小的node删除 并将 找到的最小的node的右节点 只想返回的根node
                current.right = removeMinNode(node.right);
                // 将最小节点的左孩子指向当前删除节点的左节点
                current.left = node.left;
                node.left = node.right = null;
                // 并将当前节点返回
                return current;
            }
        }
    }

    @Override
    public String toString() {
        return "Tree{" +
                "size=" + size +
                ", root=" + root +
                '}';
    }
}
