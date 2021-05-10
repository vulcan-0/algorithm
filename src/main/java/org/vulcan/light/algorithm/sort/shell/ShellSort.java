package org.vulcan.light.algorithm.sort.shell;

import org.vulcan.light.algorithm.sort.Sort;

import java.util.Arrays;

/**
 * 插入排序：希尔排序
 * 时间复杂度：平均 - O(N*logN)，最坏 - O(N²)，最好 - O(N*logN)；较多说法，说法不一
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 *
 * @author Sam Lu
 * @date 2021/5/10
 */
public class ShellSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        for (int k = result.length / 2; k > 0; k /= 2) {
            for (int i = 0; i < k; i++) {
                for (int j = i + k; j < result.length; j += k) {
                    int preIndex = j - k, current = array[j];
                    while (preIndex >= 0 && result[preIndex] > current) {
                        result[preIndex + k] = result[preIndex];
                        preIndex -= k;
                    }
                    result[preIndex + k] = current;
                }
            }
        }
        return result;
    }

}
