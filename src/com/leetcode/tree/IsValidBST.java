package com.leetcode.tree;

import java.util.ArrayList;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 */

public class IsValidBST {
    int prev = Integer.MIN_VALUE;
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(2);
//        treeNode.left = new TreeNode(1);
//        treeNode.right = new TreeNode(3);
//        IsValidBST isValidBST = new IsValidBST();
//        boolean bool = isValidBST.isValidBST(treeNode);
//        System.out.println(bool);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(!isValidBST(root.left)) {
            return false;
        }
        if(root.val <= prev) {
            return false;
        }
        prev = root.val;

        return isValidBST(root.right);
    }

//    public void getValue(TreeNode root, ArrayList<Integer> values) {
//        if(root == null) {
//            return;
//        }
//        getValue(root.left,values);
//        values.add(root.val);
//        getValue(root.right,values);
//    }
//
//    public boolean isValidBST(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        getValue(root,list);
//        for (int i = 0; i< list.size() - 1; i++) {
//            if(list.get(i) >= list.get(i + 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
