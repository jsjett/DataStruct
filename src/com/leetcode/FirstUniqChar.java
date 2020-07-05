package com.leetcode;

import java.util.HashMap;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 */
public class FirstUniqChar {
    private class Node {
        public int index;
        public int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public int firstUniqChar(String s) {
        if("".equals(s)) {
            return -1;
        }
        HashMap<Character, Node> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Node node = map.get(c);
            if (node == null) {
                map.put(c, new Node(i, 1));
            } else {
                node.count = node.count + 1;
                map.put(c, node);
            }
        }
        int result = -1;
        for (Character c : map.keySet()) {
            Node current = map.get(c);
            if(current.count == 1) {
                if(result == -1) {
                    result = current.index;
                }
                result = Math.min(result, current.index);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        String s = "cdabcaabb";
        int result = firstUniqChar.firstUniqChar(s);
        System.out.println(result);
    }
}
