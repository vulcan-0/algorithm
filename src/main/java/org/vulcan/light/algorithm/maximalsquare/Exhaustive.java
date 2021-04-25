package org.vulcan.light.algorithm.maximalsquare;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大正方形 - 枚举算法
 *
 * @author Sam Lu
 * @createdOn 2021/4/18
 */
public class Exhaustive {

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int max = 0;
        List<char[][]> list = new ArrayList();
        for (int i = 1; i <= Math.min(matrix.length, matrix[0].length); i++) {
            char[][] temp = i == 1 ? matrix : new char[matrix.length - i + 1][matrix[0].length - i + 1];
            list.add(temp);

            label:
            for (int j = 0; j < temp.length; j++) {
                for (int k = 0; k < temp[j].length; k++) {
                    if (i > 1) {
                        if (list.get(i - 2)[j][k] == '1' && list.get(i - 2)[j][k + 1] == '1'
                                && list.get(i - 2)[j + 1][k] == '1' && list.get(i - 2)[j + 1][k + 1] == '1') {
                            temp[j][k] = '1';
                        } else {
                            temp[j][k] = '0';
                        }
                    }

                    if (temp[j][k] == '1') {
                        max = Math.max(i * i, max);
                        if (i == 1) {
                            break label;
                        }
                    }
                }
            }
        }
        return max;
    }

}
