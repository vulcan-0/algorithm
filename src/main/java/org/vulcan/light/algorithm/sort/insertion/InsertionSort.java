package org.vulcan.light.algorithm.sort.insertion;

import org.vulcan.light.algorithm.sort.Sort;

/**
 * 插入排序：简单插入排序
 * 时间复杂度：平均 - O(N²)，最坏 - O(N²)，最好 - O(N)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 *
 * @author Sam Lu
 * @date 2021/5/8
 */
public class InsertionSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = new int[array.length];
        result[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            int preIndex = i - 1, current = array[i];
            while (preIndex >= 0 && result[preIndex] > current) {
                result[preIndex + 1] = result[preIndex];
                preIndex--;
            }
            result[preIndex + 1] = current;
        }
        return result;
    }

}
