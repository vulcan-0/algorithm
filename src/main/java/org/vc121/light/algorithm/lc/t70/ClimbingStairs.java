package org.vc121.light.algorithm.lc.t70;

/**
 * 70. 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/
 *
 * @author Sam Lu
 * @date 2022/6/5
 */
public class ClimbingStairs {

    /**
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 4;

        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(n));
    }

    /**
     * 滚动数组
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int first = 1, second = 2, third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

}
