package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelOrder {
    public static void main(String[] args) {
        int result = (int) (Math.log(1) / Math.log(2));
        System.out.println(result);
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // 二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i< size; i++) {
                TreeNode current = queue.remove();
                temp.add(current.val);
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
