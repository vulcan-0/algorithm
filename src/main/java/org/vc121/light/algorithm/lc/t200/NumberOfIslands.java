package org.vc121.light.algorithm.lc.t200;

/**
 * 200. 岛屿数量
 * https://leetcode.cn/problems/number-of-islands/
 *
 * @author Sam Lu
 * @date 2022/06/17
 */
public class NumberOfIslands {

    /**
     * // 输入：grid = [
     * //   ["1","1","1","1","0"],
     * //   ["1","1","0","1","0"],
     * //   ["1","1","0","0","0"],
     * //   ["0","0","0","0","0"]
     * // ]
     * // 输出：1
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(grid));
    }

    /**
     * 深度遍历，所到之处置为0
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1') {
                    dfs(grid, row, column);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length
                || grid[row][column] == '0') {
            return;
        }
        grid[row][column] = '0';
        dfs(grid, row - 1, column);
        dfs(grid, row + 1, column);
        dfs(grid, row, column - 1);
        dfs(grid, row, column + 1);
    }

}
