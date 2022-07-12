package org.vc121.light.algorithm.lc.t20;

import org.vc121.light.algorithm.zcommon.ListNode;
import org.vc121.light.algorithm.zcommon.Printer;

/**
 * 21. 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 *
 * @author Sam Lu
 * @date 2022/6/6
 */
public class MergeTwoSortedLists {

    /**
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(4)));
        Printer.printListNode(list1);
        ListNode list2 = new ListNode(1).setNext(new ListNode(3).setNext(new ListNode(4)));
        Printer.printListNode(list2);

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode newNode = mergeTwoSortedLists.mergeTwoLists(list1, list2);
        Printer.printListNode(newNode);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(0);
        ListNode current = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = list1 != null ? list1 : list2;
        return preHead.next;
    }

}
