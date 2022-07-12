package org.vc121.light.algorithm.sort.heap;

import org.vc121.light.algorithm.sort.Sort;

import java.util.Arrays;

/**
 * 选择排序：堆排序
 * 时间复杂度：平均 - O(N*logN)，最坏 - O(N*logN)，最好 - O(N*logN)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 *
 * @author Sam Lu
 * @date 2021/5/11
 */
public class HeapSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);

        int n = result.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(result, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = result[0];
            result[0] = result[i];
            result[i] = temp;

            heapify(result, i, 0);
        }

        return result;
    }

    private void heapify(int[] array, int n, int i) {
        int lastIndex = i, largest = array[i];
        int left = 2 * i + 1;
        if (left < n && array[left] > largest) {
            largest = array[left];
            lastIndex = left;
        }
        int right = 2 * i + 2;
        if (right < n && array[right] > largest) {
            largest = array[right];
            lastIndex = right;
        }

        if (lastIndex != i) {
            array[lastIndex] = array[i];
            array[i] = largest;
            heapify(array, n, lastIndex);
        }
    }

}
