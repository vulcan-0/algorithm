package org.vc121.light.algorithm.lc.t300;

import org.vc121.light.algorithm.zcommon.Printer;

/**
 * 338. 比特位计数
 * https://leetcode.cn/problems/counting-bits/
 *
 * @author Sam Lu
 * @date 2022/08/02
 */
public class CountingBits {

    /**
     * 输入：n = 2
     * 输出：[0,1,1]
     * 解释：
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 2;

        CountingBits countingBits = new CountingBits();
        int[] result = countingBits.countBits(n);
        Printer.printArray(result);
    }

    /**
     * 最高有效位
     *
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

}
