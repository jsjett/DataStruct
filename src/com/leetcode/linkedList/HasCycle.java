package com.leetcode.linkedList;

/**
 * 环形链表
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class HasCycle {


    public static void main(String[] args) {
        HasCycle hasCycle = new HasCycle();
        ListNode node = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(hasCycle.hasCycle(node));
    }

    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while (p != null && p.next != null) {
            if(q.next == null || q.next.next == null) {
                return false;
            }
            q = q.next.next;
            p = p.next;
            if(p == q) {
                return true;
            }
        }
        return false;
    }
}
