package com.leetcode.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean is = isPalindrome.isPalindrome("race a car");
        System.out.println(is);
    }
    // 我的解法
//    public boolean isPalindrome(String s) {
//        String pattern = "[0-9a-zA-Z]";
//        StringBuilder str = new StringBuilder();
//        for (int i = 0; i< s.length(); i++) {
//            String c = s.substring(i, i+1);
//            if(Pattern.matches(pattern, c)) {
//                str.append(c.toLowerCase());
//            }
//        }
//        String res = str.toString();
//
//        for (int i = 0; i < res.length() / 2; i++) {
//            if(res.charAt(i) != res.charAt(res.length() - i -1)) {
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            while (i < j && !check(s.charAt(i))) i++;
            while (j > i && !check(s.charAt(j))) j--;
            if (s.charAt(i) != s.charAt(j)
                    /**
                     * 和大小写字母的Ascii码的二进制表示有关。
                     * 在相同字母的大小写的二进制表示里，只有第5位不同，
                     * 异或32可以起到只改变第5位的效果，从而实现大小写的转化
                     */
                    && s.charAt(i) != (s.charAt(j) ^ 32)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(char chr) {
        if ((chr >= '0' && chr <= '9')
                || (chr >= 'a' && chr <= 'z')
                || (chr >= 'A' && chr <= 'Z')) {
            return true;
        }
        return false;
    }
}
