package org.vc121.light.algorithm.lc.t200;

import org.vc121.light.algorithm.zcommon.ListNode;

/**
 * 234. 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/
 *
 * @author Sam Lu
 * @date 2022/06/17
 */
public class PalindromeLinkedList {

    /**
     * 输入：head = [1,2,2,1]
     * 输出：true
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1)
                .setNext(new ListNode(2)
                        .setNext(new ListNode(2)
                                .setNext(new ListNode(1))));

        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(head));
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow);
        boolean result = true;
        while (result && slow != null) {
            if (head.val != slow.val) {
                result = false;
            }
            head = head.next;
            slow = slow.next;
        }
        return result;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
