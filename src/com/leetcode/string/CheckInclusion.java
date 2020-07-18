package com.leetcode.string;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */

public class CheckInclusion {

    public boolean isEquals(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        String result = s1;
        for (int i = 0; i< s2.length(); i++) {
            String c = s2.substring(i, i + 1);
            result = result.replaceFirst(c, "");
        }

        return result.equals("");
    }

    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        for (int i = 0; i< s2.length() - len + 1; i++) {
            String current = s2.substring(i, i + len);
            if(isEquals(s1, current)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        int result = 0;
        for (int i = 0; i< str1.length(); i++) {
            char c = str1.charAt(i);
            result += (int) c;
        }
        System.out.println(result);

    }

}
