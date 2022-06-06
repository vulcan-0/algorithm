package org.vulcan.light.algorithm.zcommon;

/**
 * @author Sam Lu
 * @date 2022/6/2
 */
public class ListNode {

    public ListNode next;
    public int val;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode listNode) {
        this.val = val;
        this.next = listNode;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }

}
