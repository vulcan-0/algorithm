package org.vc121.light.algorithm.zcommon;

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

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }

}
