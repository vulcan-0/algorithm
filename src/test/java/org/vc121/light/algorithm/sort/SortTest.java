package org.vc121.light.algorithm.sort;

import org.vc121.light.algorithm.sort.bubble.BubbleSort;
import org.vc121.light.algorithm.sort.bucket.BucketSort;
import org.vc121.light.algorithm.sort.counting.CountingSort;
import org.vc121.light.algorithm.sort.heap.HeapSort;
import org.vc121.light.algorithm.sort.insertion.InsertionSort;
import org.vc121.light.algorithm.sort.merge.MergeSort;
import org.vc121.light.algorithm.sort.quick.QuickSort;
import org.vc121.light.algorithm.sort.radix.RadixSort;
import org.vc121.light.algorithm.sort.selection.SelectionSort;
import org.vc121.light.algorithm.sort.shell.ShellSort;

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

        Sort bucketSort = new BucketSort();
        sortedArray = bucketSort.sort(sourceArray);
        printArray("BucketSort source array: ", sourceArray);
        printArray("BucketSort sorted array: ", sortedArray);

        Sort radixSort = new RadixSort();
        sortedArray = radixSort.sort(sourceArray);
        printArray("RadixSort source array: ", sourceArray);
        printArray("RadixSort sorted array: ", sortedArray);
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
