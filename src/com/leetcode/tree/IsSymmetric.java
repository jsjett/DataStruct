package com.leetcode.tree;

import com.data.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * <p>
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class IsSymmetric {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 迭代实现检测二叉树是否对称
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if(n1 == null && n2 == null) {
                continue;
            }
            if(n1 == null || n2 == null) {
                return false;
            }

            if(n1.val != n2.val) {
                return false;
            }
            queue.add(n1.left);
            queue.add(n2.right);
            queue.add(n1.right);
            queue.add(n2.left);
        }
        return true;
    }

//    public boolean isSymmetric(TreeNode root) {
//
//        return isSymmetric(root, root);
//    }
//
//    // 递归方法实现树的对称检测
//    private boolean isSymmetric(TreeNode t1,TreeNode t2) {
//        // 如果两科树都是空 说明到了叶子节点 所以对称
//        if(t1 == null && t2 == null) {
//            return true;
//        }
//        // 如果存在一颗是空 一颗不是空的情况 说明不对称
//        if(t1 == null || t2 == null) {
//            return false;
//        }
//        return t1.val == t2.val && isSymmetric(t1.left,t2.right) && isSymmetric(t1.right, t2.left);
//    }
}
