package com.data.trie;

import java.util.TreeMap;

/**
 * trie 字典树
 */
public class MyTrie implements Trie {

    private int size;

    private class Node {
        // 标识 当遍历到当前node的时候 是否从root到此node是否表示一个单词
        public boolean isWord;
        public TreeMap<Character, Node> next;
        // 当访问当前节点的时候 跟节点相同的字符出现的次数
        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    public MyTrie() {
        size  = 0;
        root = new Node();
    }



    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 向字典树中添加一个单词
     * @param word 待添加的单词
     */
    @Override
    public void add(String word) {
        Node current = root;
        for (int i = 0; i< word.length(); i++) {
            char c= word.charAt(i);
            if(current.next.get(c) == null) {
                current.next.put(c,new Node());
            }
            current = current.next.get(c);
        }

        // 当循环走完 需要将最后一个节点的标记为单词的结尾
        // 循环走完 如果已经是单词了 则不需要维护size  如果不是单词 则将当前Nod标记成单词
        // 并且size ++
        if(!current.isWord) {
            current.isWord = true;
            size ++;
        }
    }

    /**
     * 向字典树中添加一个单词 递归写法
     * @param word 待添加的单词
     */
    public void addWithDeep(String word) {
        addWithDeep(root, word, 0);
    }

    private void addWithDeep(Node current, String word, int deep) {
        if(deep == word.length()) {
            if(!current.isWord) {
                current.isWord = true;
                size ++;
            }
            return;
        }

        char c = word.charAt(deep);
        if(current.next.get(c) == null) {
            current.next.put(c, new Node());
        }

        deep ++;

        addWithDeep(current.next.get(c), word, deep);
    }

    /**
     * 检查当前字典树中是否存在单词word
     * @param word 待检查的单词
     * @return true 代表存在
     */
    public boolean contains(String word) {

        Node current = root;

        for (int i = 0; i< word.length(); i++) {
            char c = word.charAt(i);
            if(current.next.get(c) == null) {
                return false;
            }
            current = current.next.get(c);
        }

        return current.isWord;
    }

    /**
     * 检查字典树中是否存在以prefix开头的单词
     * @param prefix 待检查的前缀
     * @return true 代表存在
     */
    public boolean hasPrefix(String prefix) {
        Node current = root;

        for (int i = 0; i< prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(current.next.get(c) == null) {
                return false;
            }
            current = current.next.get(c);
        }

        return true;
    }

    /**
     * 搜索
     * @param word 待搜索的单词 如果遇到. 则通配
     * @return true表示搜索到了
     */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    /**
     * 搜索实现
     * @param node 基于哪个节点开始
     * @param str 搜索的字符串
     * @param index 从字符串的哪个索引开始
     * @return true 代表搜索到了
     */
    private boolean search(Node node, String str, int index) {
        // 如果当前索引等于字符串长度 说明递归到底 则判断当前当前节点是否表示是单词结束
        if(index == str.length()) {
            return node.isWord;
        }

        char c = str.charAt(index);
        if(c != '.') {

            if(node.next.get(c) == null) {
                return false;
            }
            return search(node.next.get(c), str, index + 1);

        }else {

            for (char nextChar: node.next.keySet()) {
                if(search(node.next.get(nextChar), str, index + 1)) {
                    return true;
                }
            }

            return false;
        }
    }
}
