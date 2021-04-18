package org.vulcan.light.algorithm.palindromic;

/**
 * 最长回文字子串 - 动态规划算法
 *
 * @author luxiaocong
 * @createdOn 2021/4/18
 */
public class DynamicProgramming {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        // 只有一个字符肯定为回文串
        for (int i = 0; i < len - 1; i++) {
            dp[i][i] = true;
        }

        int left = 0;
        int max = 1;
        char[] chars = s.toCharArray();
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                int j = i + l - 1;
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (l <= 2) {
                        // 两个字符相同，则为回文串
                        dp[i][j] = true;
                    } else {
                        // 大于两个字符的子串，在两端字符相同时，是否是回文串，取决于子串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 是回文串，且比之前的长
                if (dp[i][j] && l > max) {
                    left = i;
                    max = l;
                }
            }
        }
        return s.substring(left, left + max);
    }

}
