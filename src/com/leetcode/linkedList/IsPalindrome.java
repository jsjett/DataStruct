package com.leetcode.linkedList;

/**
 * ------回文链表-----
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class IsPalindrome {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    // 采用双指针方法  快指针走是慢指针的两倍 慢指针边走边翻转
    // 当快指针走到底 说明慢指针走到了一半的位置 然后开始比较
    public boolean isPalindrome(ListNode head) {
        ListNode prevNode = null;
        ListNode nextNode = null;
        ListNode p = head;
        ListNode q = head;
        // 首先遍历找到中间位置 将中间位置开始到结尾的进行翻转
        while (p != null) {
            if(q != null && q.next != null) {
                q = q.next.next;
                p = p.next;
            }else {
                // 将后半段翻转
                nextNode = p.next;
                p.next = prevNode;
                prevNode = p;
                p = nextNode;
            }
        }

        while (head != null && prevNode != null) {
            if(head.val != prevNode.val) {
                return false;
            }
            head = head.next;
            prevNode = prevNode.next;
        }

        return true;
    }
}
