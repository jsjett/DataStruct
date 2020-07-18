package com.leetcode.array;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int len  = nums.length;
        k = k % len;
        int count = 0;         // 记录交换位置的次数，n个同学一共需要换n次
        for(int start = 0; count < len; start++) {
            int cur = start;       // 从0位置开始换位子
            int pre = nums[cur];
            do{
                int next = (cur + k) % len;
                int temp = nums[next];    // 来到角落...
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            }while(start != cur)  ;     // 循环暂停，回到起始位置，角落无人

        }
    }

    public void test(int[] nums, int k) {
        int len  = nums.length;
        k = k % len;
        int count = 0;

        for (int start = 0; count < len; start ++) {
            int current = start; // 当前正在换位置的索引
            int prev = nums[start]; // 第一个换位置的值

            while (count < len) {
                // 要换到的位置的那个索引
                int next = (current + k) % len;
                int temp = nums[next]; // 要换到的那个位置的值
                nums[next] = prev;
                prev = temp;
                current = next;
                count ++;
                // 如果当前要交换的又回到了开始的那个 则结束循环  start + 1
                if(current == start) {
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {-1,-100,3,99};
        int k = 2;
        rotateArray.test(nums, k);

        for (int i = 0; i< nums.length; i++) {
            System.out.print(nums[i] + "->");
        }
    }
}
