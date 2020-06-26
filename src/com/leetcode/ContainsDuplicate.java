package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return true;
            }else {
                map.put(nums[i], nums[i]);
            }
        }
        return false;
    }
    // 性能特别差
    public boolean containsDuplicate1(int[] nums) {

        for (int i = 0; i< nums.length - 1; i++) {
            for (int j = i + 1; j<nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {

        return false;
    }
}
