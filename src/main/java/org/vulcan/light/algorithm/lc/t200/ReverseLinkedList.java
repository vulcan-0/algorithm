package org.vulcan.light.algorithm.lc.t200;

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

    /**
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1)
                .setNext(new ListNode(2)
                        .setNext(new ListNode(3)
                                .setNext(new ListNode(4)
                                        .setNext(new ListNode(5)))));
        Printer.printListNode(head);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode newNode1 = reverseLinkedList.reverseList1(head);
        Printer.printListNode(newNode1);
        ListNode newNode2 = reverseLinkedList.reverseList2(newNode1);
        Printer.printListNode(newNode2);
    }

    public ListNode reverseList1(ListNode head) {
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

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
