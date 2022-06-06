package org.vulcan.light.algorithm.lc.t1;

import org.vulcan.light.algorithm.zcommon.ListNode;
import org.vulcan.light.algorithm.zcommon.Printer;

/**
 * 2. 两数相加
 * https://leetcode.cn/problems/add-two-numbers/
 *
 * @author Sam Lu
 * @date 2022/6/4
 */
public class AddTwoNumbers {

    /**
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2).setNext(new ListNode(4).setNext(new ListNode(3)));
        Printer.printListNode(l1);
        ListNode l2 = new ListNode(5).setNext(new ListNode(6).setNext(new ListNode(4)));
        Printer.printListNode(l2);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        Printer.printListNode(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int carry = sum / 10;
        ListNode result = new ListNode(sum % 10);
        ListNode currentNode = result;

        while (l1.next != null || l2.next != null) {
            int a = l1.next != null ? l1.next.val : 0;
            int b = l2.next != null ? l2.next.val : 0;
            sum = a + b + carry;
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;

            if (l1.next != null) {
                l1.next = l1.next.next;
            }
            if (l2.next != null) {
                l2.next = l2.next.next;
            }
        }

        if (carry != 0) {
            currentNode.next = new ListNode(carry);
        }
        return result;
    }

}
