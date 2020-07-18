package com.leetcode.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public String twoStringCommon(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int minLen = Math.min(str1.length(), str2.length());
        for (int i = 0; i< minLen; i++) {
            if(str1.charAt(i) == str2.charAt(i)) {
                sb.append(str1.charAt(i));
            }else {
                break;
            }
        }
        return sb.toString();
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }
        String result = "";
        for (int i = 0; i< strs.length - 1; i++) {
            String common = twoStringCommon(strs[i], strs[i+1]);
            if(common.equals("")) {
                return "";
            }else {
                if(result.equals("")) {
                    result = common;
                }else if(result.length() > common.length()) {
                    result = common;
                }
            }
        }
        return result;
    }

}
