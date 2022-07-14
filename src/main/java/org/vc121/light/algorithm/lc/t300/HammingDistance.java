package org.vc121.light.algorithm.lc.t300;

/**
 * 461. 汉明距离
 * https://leetcode.cn/problems/hamming-distance/
 *
 * @author Sam Lu
 * @date 2022/07/14
 */
public class HammingDistance {

    /**
     * 输入：x = 1, y = 4
     * 输出：2
     * 解释：
     * // 1   (0 0 0 1)
     * // 4   (0 1 0 0)
     * //        ↑   ↑
     * 上面的箭头指出了对应二进制位不同的位置。
     *
     * @param args
     */
    public static void main(String[] args) {
        int x = 1, y = 4;

        HammingDistance hammingDistance = new HammingDistance();
        System.out.println(hammingDistance.hammingDistance(x, y));
    }

    public int hammingDistance(int x, int y) {
        int count = 0, n = x ^ y;
        while (n > 0) {
            count += 1 & n;
            n >>= 1;
        }
        return count;
    }

}
