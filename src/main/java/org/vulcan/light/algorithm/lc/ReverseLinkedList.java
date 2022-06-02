package org.vulcan.light.algorithm.lc;

import org.vulcan.light.algorithm.zcommon.ListNode;
import org.vulcan.light.algorithm.zcommon.Printer;

/**
 * 206. 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/
 *
 * @author Sam Lu
 * @date 2022/6/2
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1)
                .setNext(new ListNode(2)
                        .setNext(new ListNode(3)
                                .setNext(new ListNode(4)
                                        .setNext(new ListNode(5)))));
        Printer.printListNode(head);

        ListNode newNode1 = reverse1(head);
        Printer.printListNode(newNode1);
        ListNode newNode2 = reverse2(newNode1);
        Printer.printListNode(newNode2);
    }

    private static ListNode reverse1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
