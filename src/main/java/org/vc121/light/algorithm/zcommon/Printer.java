package org.vc121.light.algorithm.zcommon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sam Lu
 * @date 2022/6/2
 */
public class Printer {

    public static void printArray(int[][] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("[]");
            return;
        }

        StringBuilder builder = new StringBuilder("[");
        for (int[] subArray : array) {
            builder.append(buildArray(subArray)).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        System.out.println(builder);
    }

    public static void printArray(int[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("[]");
            return;
        }

        System.out.println(buildArray(array));
    }

    private static String buildArray(int[] array) {
        StringBuilder builder = new StringBuilder("[");
        for (int num : array) {
            builder.append(num).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();
    }

    public static void printList(List<?> list) {
        if (list == null) {
            System.out.println("null");
            return;
        }
        if (list.size() == 0) {
            System.out.println("[]");
            return;
        }
        System.out.println(buildList(list));
    }

    private static String buildList(List<?> list) {
        StringBuilder builder = new StringBuilder("[");
        for (Object obj : list) {
            if (obj instanceof List) {
                builder.append(buildList((List<?>) obj)).append(", ");
            } else {
                builder.append(obj).append(", ");
            }
        }
        if (builder.toString().endsWith(", ")) {
            builder.delete(builder.length() - 2, builder.length());
        }
        builder.append("]");
        return builder.toString();
    }

    public static void printListNode(ListNode listNode) {
        if (listNode == null) {
            System.out.println("NULL");
            return;
        }

        Set<ListNode> listNodeSet = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        ListNode current = listNode;
        while (current != null && listNodeSet.add(current)) {
            builder.append(current.val).append(" -> ");
            current = current.next;
        }
        builder.append("NULL");
        System.out.println(builder);
    }

}
