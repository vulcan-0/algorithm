package org.vulcan.light.algorithm.sort.bubble;

import org.vulcan.light.algorithm.sort.Sort;

import java.util.Arrays;

/**
 * 冒泡排序
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
        for (int i = 0; i < result.length; i++) {
            boolean flag = true;
            for (int j = 0; j < result.length - 1; j++) {
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
