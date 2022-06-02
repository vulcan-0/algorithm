package org.vulcan.light.algorithm.zcommon;

/**
 * @author Sam Lu
 * @date 2022/6/2
 */
public class ListNode {

    public ListNode next;
    public int value;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }

}
