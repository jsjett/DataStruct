package com.data.trie;

import java.util.TreeMap;

///**
// * trie 字典树
// */
public class Main {
    public static void main(String[] args) {
        MyTrie myTrie = new MyTrie();
        myTrie.add("jello");
        myTrie.add("jejett");
        myTrie.add("jsjett");
        System.out.println(myTrie.search("jdjett"));
    }
}
