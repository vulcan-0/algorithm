package org.vulcan.light.algorithm.lc.t40;

import org.vulcan.light.algorithm.zcommon.Printer;

/**
 * 48. 旋转图像
 * https://leetcode.cn/problems/rotate-image/
 *
 * @author Sam Lu
 * @date 2022/06/18
 */
public class RotateImage {

    /**
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[7,4,1],[8,5,2],[9,6,3]]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Printer.printArray(matrix);

        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
        Printer.printArray(matrix);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

}
