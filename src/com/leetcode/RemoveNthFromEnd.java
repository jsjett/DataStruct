package com.leetcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthFromEnd {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 从倒数删除节点
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode virtualHead = new ListNode(0);
        virtualHead.next = head;
        ListNode p = virtualHead;
        ListNode q = virtualHead;
        for (int i = 0; i<= n;i++) {
            q = q.next;
        }

        while (q != null) {
            q = q.next;
            p = p.next;
        }

        p.next = p.next.next;

        return virtualHead.next;
    }
}
