package com.leetcode.linkedList;

public class MergeTwoLists {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//    public static void main(String[] args) {
//        MergeTwoLists mergeTwoLists = new MergeTwoLists();
//        ListNode a = new ListNode(4);
//        ListNode b = new ListNode(2,a);
//        ListNode l1 = new ListNode(1, b);
//        ListNode a2 = new ListNode(4);
//        ListNode b2 = new ListNode(3,a2);
//        ListNode l2 = new ListNode(1, b2);
//        ListNode result = mergeTwoLists.mergeTwoLists(l1,l2);
//        while (result != null) {
//            System.out.println(result.val);
//            result = result.next;
//        }
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;
        while (l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                if(l1.val <= l2.val) {
                    current.next = new ListNode(l1.val);
                    l1 = l1.next;
                }else {
                    current.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }else if(l1 == null) {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }else if(l2 == null) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            }

            current = current.next;
        }

        return head.next;
    }
}
