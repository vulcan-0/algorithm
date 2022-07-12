package org.vc121.light.algorithm.lc.t100;

import org.vc121.light.algorithm.zcommon.ListNode;
import org.vc121.light.algorithm.zcommon.Printer;

/**
 * 148. 排序链表
 * https://leetcode.cn/problems/sort-list/
 *
 * @author Sam Lu
 * @date 2022/07/05
 */
public class SortList {

    /**
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(4)
                .setNext(new ListNode(2)
                        .setNext(new ListNode(1)
                                .setNext(new ListNode(3))));
        Printer.printListNode(head);

        SortList sortList = new SortList();
        ListNode newNode = sortList.sortList(head);
        Printer.printListNode(newNode);
    }

    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (int step = 2; step / 2 < len; step *= 2) {
            ListNode curr = dummy;
            for (int i = 0; i < len; i += step) {
                ListNode slow = curr.next, fast = curr.next;
                for (int j = i; j < i + step / 2 && slow != null; j++) {
                    slow = slow.next;
                }
                for (int j = i; j < i + step / 2 && fast != null; j++) {
                    fast = fast.next != null ? fast.next.next : null;
                }
                curr.next = merge(curr.next, slow, slow, fast);
                while (curr.next != fast) {
                    curr = curr.next;
                }
            }
        }
        return dummy.next;
    }

    private ListNode merge(ListNode list1, ListNode list1End, ListNode list2, ListNode list2End) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy, temp1 = list1, temp2 = list2;
        while (temp1 != null || temp2 != null) {
            if ((temp1 != null && temp2 != null && temp1.val < temp2.val) || temp2 == null) {
                curr.next = temp1;
                temp1 = temp1.next;
            } else {
                curr.next = temp2;
                temp2 = temp2.next;
            }
            temp1 = temp1 == list1End ? null : temp1;
            temp2 = temp2 == list2End ? null : temp2;
            curr = curr.next;
        }
        curr.next = list2End;
        return dummy.next;
    }

}
