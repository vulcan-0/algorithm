package org.vulcan.light.algorithm.maximalsquare;

/**
 * 最大正方形几种算法的性能测试
 *
 * @author Sam Lu
 * @createdOn 2021/4/18
 */
public class MaximalSquareTest {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        int result = 0;

        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            result = DynamicProgramming.maximalSquare(matrix);
        }
        System.out.println("动态规划结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            result = Exhaustive.maximalSquare(matrix);
        }
        System.out.println("暴力穷举结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");
    }

}
