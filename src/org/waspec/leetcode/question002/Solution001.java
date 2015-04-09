package org.waspec.leetcode.question002;

public class Solution001 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(9);
        list1.next = new ListNode(9);
        list1.next.next = new ListNode(9);

        ListNode list2 = new ListNode(9);
        list2.next = new ListNode(9);

        Solution001 solution001 = new Solution001();
        ListNode list = solution001.addTwoNumbers(list1, list2);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        int carray = 0;
        ListNode head = new ListNode(-1); // dummy head
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode q = head;
        while (p1 != null || p2 != null || carray != 0) { // 坑：就算两个list已经到头了，如果还有进位，也需要加node
            q.next = new ListNode(0);
            ListNode newNode = q.next;
            if (p1 != null) {
                newNode.val += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                newNode.val += p2.val;
                p2 = p2.next;
            }

            newNode.val += carray;
            carray = newNode.val / 10; // 这句是最后提出来的
            newNode.val %= 10; // 坑

            q = q.next;
        }

        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * 1. 使用dummy head处理链表延续的典例
 * 2. 需要经常练！
 */