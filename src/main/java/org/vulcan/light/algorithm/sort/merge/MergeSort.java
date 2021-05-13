package org.vulcan.light.algorithm.sort.merge;

import org.vulcan.light.algorithm.sort.Sort;

import java.util.Arrays;

/**
 * 归并排序：二路归并排序
 * 时间复杂度：平均 - O(N*logN)，最坏 - O(N*logN)，最好 - O(N*logN)
 * 空间复杂度：O(N)
 * 稳定性：稳定
 *
 * @author Sam Lu
 * @date 2021/5/13
 */
public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);

        int left = 0, middle = result.length / 2, right = result.length - 1;
        mergeSort(result, left, middle, right);

        return result;
    }

    private void mergeSort(int[] array, int left, int middle, int right) {
        if (left < right) {
            int n = middle - left, m = right - middle + 1;
            mergeSort(array, left, left + n / 2, middle - 1);
            mergeSort(array, middle, middle + m / 2, right);

            int[] leftArr = new int[n], rightArr = new int[m];
            int k = left;
            for (int i = 0; i < n; i++) {
                leftArr[i] = array[k++];
            }
            for (int i = 0; i < m; i++) {
                rightArr[i] = array[k++];
            }

            int i = 0, j = 0;
            k = left;
            while (i < n && j < m) {
                if (leftArr[i] < rightArr[j]) {
                    array[k++] = leftArr[i++];
                } else {
                    array[k++] = rightArr[j++];
                }
            }

            while (i < n) {
                array[k++] = leftArr[i++];
            }
            while (j < m) {
                array[k++] = rightArr[j++];
            }
        }
    }

}
