package org.vc121.light.algorithm.lc.t100;

import org.vc121.light.algorithm.zcommon.ListNode;
import org.vc121.light.algorithm.zcommon.Printer;

/**
 * 141. 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/
 *
 * @author Sam Lu
 * @date 2022/06/08
 */
public class LinkedListCycle {

    /**
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode2);
        Printer.printListNode(listNode1);

        LinkedListCycle linkedListCycle = new LinkedListCycle();
        System.out.println(linkedListCycle.hasCycle(listNode1));
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
