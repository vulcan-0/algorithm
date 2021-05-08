package org.vulcan.light.algorithm.sort;

import org.vulcan.light.algorithm.sort.bubble.BubbleSort;

/**
 * @author Sam Lu
 * @date 2021/5/8
 */
public class SortTest {

    public static void main(String[] args) {
        int[] sourceArray = {4, -4, 6, 12, 56, 8, 12};

        Sort bubbleSort = new BubbleSort();
        int[] sortedArray = bubbleSort.sort(sourceArray);
        printArray("BubbleSort source array: ", sourceArray);
        printArray("BubbleSort sorted array: ", sortedArray);
    }

    private static void printArray(String message, int[] array) {
        System.out.print(message);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(',');
            }
        }
        System.out.println();
    }

}
