package org.vc121.light.algorithm.sort.selection;

import org.vc121.light.algorithm.sort.Sort;

import java.util.Arrays;

/**
 * 选择排序：简单选择排序
 * 时间复杂度：平均 - O(N²)，最坏 - O(N²)，最好 - O(N²)
 * 空间复杂度：O(1)
 * 稳定性：不稳定 - 交换的时候不是相邻两个数交换，存在跳跃性
 *
 * @author Sam Lu
 * @date 2021/5/8
 */
public class SelectionSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        for (int i = 0; i < result.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < result.length; j++) {
                minIndex = result[j] < result[minIndex] ? j : minIndex;
            }
            if (i != minIndex) {
                int temp = result[i];
                result[i] = result[minIndex];
                result[minIndex] = temp;
            }
        }
        return result;
    }

}
