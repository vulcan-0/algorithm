package org.vulcan.light.algorithm.lc.t100;

import org.vulcan.light.algorithm.zcommon.ListNode;
import org.vulcan.light.algorithm.zcommon.Printer;

/**
 * 142. 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 *
 * @author Sam Lu
 * @date 2022/06/23
 */
public class LinkedListCycleII {

    /**
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);
        Printer.printListNode(head);

        LinkedListCycleII linkedListCycleII = new LinkedListCycleII();
        ListNode newNode = linkedListCycleII.detectCycle(head);
        Printer.printListNode(newNode);
    }

    /**
     * 快慢指针
     * <p>
     * 1. fast指针比slow指针快一倍，所以当slow指针进入环中时，fast指针会以每步为1的速度追赶slow（相对运动，相当于slow是静止的），
     * 假设环的长度为L，那么slow走一圈的步数为L，fast和slow的最远距离不超过L/2，所以fast必定在slow走完一圈前追上slow。
     * <p>
     * 2. fast = 2slow，fast = a + n * (b + c) = 2 * (a + b) => a = c + (n - 1) * (b + c)，
     * 所以，当fast和slow相遇时，令指针pointer从head开始走，每次走1步，最终pointer和slow会在链表的交叉点相遇。
     * （a为head到链表交叉点的距离，b为链表交叉点到fast和slow的相遇点的距离，c为L-b的距离）
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode pointer = head;
                while (pointer != slow) {
                    pointer = pointer.next;
                    slow = slow.next;
                }
                return pointer;
            }
        }
        return null;
    }

}
