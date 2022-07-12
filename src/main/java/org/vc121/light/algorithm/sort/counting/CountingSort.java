package org.vc121.light.algorithm.sort.counting;

import org.vc121.light.algorithm.sort.Sort;

import java.util.Arrays;

/**
 * 计数排序
 * 时间复杂度：平均 - O(N + K)，最坏 - O(N + K)，最好 - O(N + K)
 * 空间复杂度：O(N + K)
 * 稳定性：稳定
 *
 * @author Sam Lu
 * @date 2021/5/13
 */
public class CountingSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        return countingSort(result);
    }

    private int[] countingSort(int[] array) {
        int max = array[0], min = 0;
        for (int i = 1; i < array.length; i++) {
            max = array[i] > max ? array[i] : max;
            min = array[i] < min ? array[i] : min;
        }

        int len = max - min + 1;
        int[] count = new int[len];
        for (int i = 0; i < len; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }

        for (int i = 0, j = 0; j < array.length; i++) {
            while (count[i] > 0) {
                array[j++] = i + min;
                count[i]--;
            }
        }
        return array;
    }

}
