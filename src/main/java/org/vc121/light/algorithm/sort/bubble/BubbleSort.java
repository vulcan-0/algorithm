package org.vc121.light.algorithm.sort.bubble;

import org.vc121.light.algorithm.sort.Sort;

import java.util.Arrays;

/**
 * 交换排序：冒泡排序
 * 时间复杂度：平均 - O(N²)，最坏 - O(N²)，最好 - O(N)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 *
 * @author Sam Lu
 * @date 2021/5/8
 */
public class BubbleSort implements Sort {

    /**
     * flag用于优化排序效率，如果在一次比较中没有发生交换，说明数组已经是有序的，无需继续往下比较
     *
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        for (int i = 0; i < result.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < result.length - 1 - i; j++) {
                if (result[j] > result[j + 1]) {
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return result;
    }

}
