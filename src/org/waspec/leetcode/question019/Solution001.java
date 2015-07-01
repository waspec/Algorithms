package org.waspec.leetcode.question019;

/**
 * Remove Nth Node From End of List
 */

public class Solution001 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);

        Solution001 solution001 = new Solution001();
        ListNode result = solution001.removeNthFromEnd(head, 1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 长度为1的链表去掉倒数第1个的情况
        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next; // 跃过

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 1. 此题为“找到倒数第n个node的变种”。
 * 2. 中弹：长度为1的链表、删除倒数第1个。
 * 3. 使用快慢指针的时候，不要用“快指针到头”的while循环，而是用for循环
 * 4. 坏点：LeetCode没有说清如果n大于链表长度怎么办
 */