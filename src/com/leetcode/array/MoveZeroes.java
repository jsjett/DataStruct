package com.leetcode.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes {
//    public void moveZeroes(int[] nums) {
//        int endIndex = nums.length - 1;
//        for (int startIndex = 0; startIndex<= endIndex; startIndex++ ) {
//
//            if(nums[startIndex] == 0) {
//                for (int j = startIndex; j< endIndex;j++) {
//                    nums[j] = nums[j + 1];
//                }
//                nums[endIndex] = 0;
//                // 当移动后 可能存在当前start位置的元素是0 此时将索引减一 重新重startIndex开始
//                startIndex --;
//                endIndex --;
//            }
//        }
//    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i< nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }

        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] ins = {0,1,0,3,12};
        moveZeroes.moveZeroes(ins);
    }
}
