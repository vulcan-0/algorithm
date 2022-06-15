package org.vulcan.light.algorithm.lc.t20;

import org.vulcan.light.algorithm.zcommon.ListNode;
import org.vulcan.light.algorithm.zcommon.Printer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 *
 * @author Sam Lu
 * @date 2022/06/15
 */
public class MergeKSortedLists {

    /**
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * //[
     * //  1->4->5,
     * //  1->3->4,
     * //  2->6
     * //]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1).setNext(new ListNode(4).setNext(new ListNode(5)));
        ListNode listNode2 = new ListNode(1).setNext(new ListNode(3).setNext(new ListNode(4)));
        ListNode listNode3 = new ListNode(2).setNext(new ListNode(6));
        ListNode[] lists = new ListNode[]{listNode1, listNode2, listNode3};
        Printer.printListNode(listNode1);
        Printer.printListNode(listNode2);
        Printer.printListNode(listNode3);

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode result = mergeKSortedLists.mergeKLists(lists);
        Printer.printListNode(result);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!queue.isEmpty()) {
            current.next = queue.poll();
            current = current.next;
            if (current.next != null) {
                queue.offer(current.next);
            }
        }
        return dummy.next;
    }

}
