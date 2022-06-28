package org.vulcan.light.algorithm.lc.t70;

/**
 * 79. 单词搜索
 * https://leetcode.cn/problems/word-search/
 *
 * @author Sam Lu
 * @date 2022/06/28
 */
public class WordSearch {

    /**
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }};
        String word = "ABCCED";

        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        char c = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == c) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (word.length() == index) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        char c = word.charAt(index);
        if (board[i][j] != c) {
            return false;
        }
        board[i][j] = '0';
        boolean flag = dfs(board, i - 1, j, word, index + 1)
                || dfs(board, i + 1, j, word, index + 1)
                || dfs(board, i, j - 1, word, index + 1)
                || dfs(board, i, j + 1, word, index + 1);
        board[i][j] = c;
        return flag;
    }

}
