package org.vc121.light.algorithm.sort.bucket;

import org.vc121.light.algorithm.sort.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 * 时间复杂度：平均 - O(N + K)，最坏 - O(N²)，最好 - O(N)
 * 空间复杂度：O(N + K)
 * 稳定性：稳定
 *
 * @author Sam Lu
 * @date 2021/5/14
 */
public class BucketSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        return bucketSort(result, 5);
    }

    private int[] bucketSort(int[] array, int bucketSize) {
        int max = array[0], min = 0;
        for (int i = 1; i < array.length; i++) {
            max = array[i] > max ? array[i] : max;
            min = array[i] < min ? array[i] : min;
        }

        int bucketCount = (max - min + 1) / bucketSize + 1;
        List<Integer>[] bucket = new List[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < array.length; i++) {
            bucket[(array[i] - min) / bucketSize].add(array[i]);
        }

        for (int i = 0; i < bucketCount; i++) {
            Collections.sort(bucket[i]);
        }

        for (int i = 0, j = 0; i < array.length; j++) {
            while (bucket[j].size() > 0) {
                array[i++] = bucket[j].remove(0);
            }
        }
        return array;
    }

}
