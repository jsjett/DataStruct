package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < len; end ++) {
            char current = s.charAt(end);

            if(map.containsKey(current)) {
                start = Math.max(map.get(current), start);
            }
            result = Math.max(result, end - start + 1);
            map.put(current, end + 1);
        }
        return result;
    }
}
