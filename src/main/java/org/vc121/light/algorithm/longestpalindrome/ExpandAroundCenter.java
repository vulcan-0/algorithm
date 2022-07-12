package org.vc121.light.algorithm.longestpalindrome;

/**
 * 最长回文字子串 - 中心扩展算法
 *
 * @author Sam Lu
 * @date 2021/4/18
 */
public class ExpandAroundCenter {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int start = 0, end = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int len1 = expandAroundCenter(chars, i, i);
            int len2 = expandAroundCenter(chars, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
