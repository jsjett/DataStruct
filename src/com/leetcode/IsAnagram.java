package com.leetcode;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {
    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        boolean is = isAnagram.isAnagram("ac", "ab");
        System.out.println(is);
    }
//    public boolean isAnagram(String s, String t) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i< s.length(); i++) {
//            char c = s.charAt(i);
//            map.put(c, map.getOrDefault(c,0) + 1);
//        }
//
//        for (int i = 0; i< t.length(); i++) {
//            char c = t.charAt(i);
//            map.put(c, map.getOrDefault(c, 0) - 1);
//        }
//
//        for (Character c : map.keySet()) {
//            if(map.get(c) != 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        char[] charsArray = s.toCharArray();
        char[] chartArray = t.toCharArray();
        if (charsArray.length != chartArray.length) return false;

        int [] contArray = new int[26];

        for (int i = 0; i<charsArray.length; i++) {

            contArray[charsArray[i] - 'a']++;
        }

        for (int i = 0; i<chartArray.length; i++) {
            if (--contArray[chartArray[i] - 'a']<0) return false;

        }
        return true;

    }
}
