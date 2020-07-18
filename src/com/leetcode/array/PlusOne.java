package com.leetcode.array;

import java.util.ArrayList;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i< digits.length; i++) {
            list.add(digits[i]);
        }
        int index = list.size() - 1;
        list.set(index, list.get(index) + 1);
        while (index >= 0) {
            if (list.get(index) > 9) {
                int current = list.get(index);
                list.set(index, current % 10);
                // 如果index 等于0 并且前一位溢出  说明此时需要将数组的前一位扩容
                if(index == 0) {
                    list.add(0,current / 10);
                }else {
                    digits[index - 1]++;
                    list.set(index - 1, list.get(index - 1) + 1);
                }
            }
            index--;
        }

        int[] result = new int[list.size()];
        for (int i = 0; i< list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] ints = {9,9,9};
        int[] result = plusOne.plusOne(ints);
        for (int i = 0; i< result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
