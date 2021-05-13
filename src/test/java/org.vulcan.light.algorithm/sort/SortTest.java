package org.vulcan.light.algorithm.sort;

import org.vulcan.light.algorithm.sort.bubble.BubbleSort;
import org.vulcan.light.algorithm.sort.counting.CountingSort;
import org.vulcan.light.algorithm.sort.heap.HeapSort;
import org.vulcan.light.algorithm.sort.insertion.InsertionSort;
import org.vulcan.light.algorithm.sort.merge.MergeSort;
import org.vulcan.light.algorithm.sort.quick.QuickSort;
import org.vulcan.light.algorithm.sort.selection.SelectionSort;
import org.vulcan.light.algorithm.sort.shell.ShellSort;

/**
 * @author Sam Lu
 * @date 2021/5/8
 */
public class SortTest {

    public static void main(String[] args) {
        int[] sourceArray = {4, -4, 6, 12, 56, 8, 12, 1, 22, 3};

        Sort bubbleSort = new BubbleSort();
        int[] sortedArray = bubbleSort.sort(sourceArray);
        printArray("BubbleSort source array: ", sourceArray);
        printArray("BubbleSort sorted array: ", sortedArray);

        Sort quickSort = new QuickSort();
        sortedArray = quickSort.sort(sourceArray);
        printArray("QuickSort source array: ", sourceArray);
        printArray("QuickSort sorted array: ", sortedArray);

        Sort insertionSort = new InsertionSort();
        sortedArray = insertionSort.sort(sourceArray);
        printArray("InsertionSort source array: ", sourceArray);
        printArray("InsertionSort sorted array: ", sortedArray);

        Sort shellSort = new ShellSort();
        sortedArray = shellSort.sort(sourceArray);
        printArray("ShellSort source array: ", sourceArray);
        printArray("ShellSort sorted array: ", sortedArray);

        Sort selectionSort = new SelectionSort();
        sortedArray = selectionSort.sort(sourceArray);
        printArray("SelectionSort source array: ", sourceArray);
        printArray("SelectionSort sorted array: ", sortedArray);

        Sort heapSort = new HeapSort();
        sortedArray = heapSort.sort(sourceArray);
        printArray("HeapSort source array: ", sourceArray);
        printArray("HeapSort sorted array: ", sortedArray);

        Sort mergeSort = new MergeSort();
        sortedArray = mergeSort.sort(sourceArray);
        printArray("MergeSort source array: ", sourceArray);
        printArray("MergeSort sorted array: ", sortedArray);

        Sort countingSort = new CountingSort();
        sortedArray = countingSort.sort(sourceArray);
        printArray("CountingSort source array: ", sourceArray);
        printArray("CountingSort sorted array: ", sortedArray);
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
