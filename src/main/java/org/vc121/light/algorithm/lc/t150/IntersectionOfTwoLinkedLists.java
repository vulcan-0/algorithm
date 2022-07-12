package org.vc121.light.algorithm.lc.t150;

import org.vc121.light.algorithm.zcommon.ListNode;
import org.vc121.light.algorithm.zcommon.Printer;

/**
 * 160. 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 *
 * @author Sam Lu
 * @date 2022/06/23
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Intersected at '8'
     * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
     * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode headA = new ListNode(4).setNext(new ListNode(1));
        ListNode headB = new ListNode(5).setNext(new ListNode(6).setNext(new ListNode(1)));
        ListNode headC = new ListNode(8).setNext(new ListNode(4).setNext(new ListNode(5)));
        headA.next.next = headC;
        headB.next.next.next = headC;
        Printer.printListNode(headA);
        Printer.printListNode(headB);

        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        ListNode newNode = intersectionOfTwoLinkedLists.getIntersectionNode(headA, headB);
        Printer.printListNode(newNode);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA, pointB = headB;
        boolean aChanged = false, bChanged = false;
        while (pointA != null || pointB != null) {
            if (pointA == pointB) {
                return pointA;
            }
            pointA = pointA != null ? pointA.next : !aChanged ? headB : null;
            pointB = pointB != null ? pointB.next : !bChanged ? headA : null;
        }
        return null;
    }

}
