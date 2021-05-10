package org.vulcan.light.algorithm.sort.quick;

import org.vulcan.light.algorithm.sort.Sort;

import java.util.Arrays;

/**
 * 交换排序：快速排序
 * 时间复杂度：平均 - O(N*logN)，最坏 - O(N²)，最好 - O(N*logN)
 * 空间复杂度：O(logN)
 * 稳定性：不稳定
 *
 * @author Sam Lu
 * @date 2021/5/10
 */
public class QuickSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        return quickSort(result, 0, result.length - 1);
    }

    private int[] quickSort(int[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(array, left, right);
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
        return array;
    }

    private int partition(int[] array, int left, int right) {
        int pivot = right, index = left - 1;
        for (int i = left; i < pivot; i++) {
            if (array[pivot] > array[i]) {
                index++;
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
        int temp = array[index + 1];
        array[index + 1] = array[pivot];
        array[pivot] = temp;
        int partitionIndex = index + 1;
        return partitionIndex;
    }

}
