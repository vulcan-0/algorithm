package org.vc121.light.algorithm.sort.radix;

import org.vc121.light.algorithm.sort.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序
 * 时间复杂度：平均 - O(N + K)，最坏 - O(N + K)，最好 - O(N + K)
 * 空间复杂度：O(N + K)
 * 稳定性：稳定
 *
 * @author Sam Lu
 * @date 2021/5/14
 */
public class RadixSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        return radixSort(result);
    }

    private int[] radixSort(int[] array) {
        int max = array[0], min = 0;
        for (int i = 1; i < array.length; i++) {
            max = array[i] > max ? array[i] : max;
            min = array[i] < min ? array[i] : min;
        }

        for (int radix = 1; (max - min) / radix > 0; radix *= 10) {
            List<Integer>[] bucket = new List[10];
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < array.length; i++) {
                bucket[((array[i] - min) / radix) % (radix * 10)].add(array[i]);
            }

            for (int i = 0, j = 0; i < array.length; j++) {
                while (bucket[j].size() > 0) {
                    array[i++] = bucket[j].remove(0);
                }
            }
        }
        return array;
    }

}
