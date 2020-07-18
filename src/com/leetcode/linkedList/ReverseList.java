package com.leetcode.linkedList;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class ReverseList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        // 记录当前节点
        ListNode current = head;
        // 记录下一个节点
        ListNode nextNode = null;
        // 记录上一个节点
        ListNode prevNode = null;
        while (current != null) {
            // 保存下一个节点
            nextNode = current.next;
            // 将当前节点的next指向上一个
            current.next = prevNode;
            // 将上一个节点更新到当前节点
            prevNode = current;
            // 将当前的指针指向上次记录的下一个节点
            current = nextNode;
        }
        // 返回最后的节点 即头结点
        return prevNode;
    }
}