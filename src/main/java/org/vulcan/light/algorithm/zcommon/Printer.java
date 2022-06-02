package org.vulcan.light.algorithm.zcommon;

/**
 * @author Sam Lu
 * @date 2022/6/2
 */
public class Printer {

    public static void printArray(int[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }

        StringBuilder builder = new StringBuilder("[");
        for (int num : array) {
            builder.append(num).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        System.out.println(builder);
    }

    public static void printListNode(ListNode listNode) {
        if (listNode == null) {
            System.out.println("NULL");
        }

        StringBuilder builder = new StringBuilder();
        ListNode current = listNode;
        while (current != null) {
            builder.append(current.value).append(" -> ");
            current = current.next;
        }
        builder.append("NULL");
        System.out.println(builder);
    }

}
