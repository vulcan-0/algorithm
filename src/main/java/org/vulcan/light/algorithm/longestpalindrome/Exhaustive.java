package org.vulcan.light.algorithm.longestpalindrome;

/**
 * 最长回文字子串 - 枚举算法
 *
 * @author Sam Lu
 * @date 2021/4/18
 */
public class Exhaustive {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int length = s.length();
        char[] chars = s.toCharArray();

        // rLen=字符串总长度-子串长度，比如：子串长度为length，则rLen为0，子串长度为2，则rLen为length-2
        for (int rLen = 0; rLen <= length - 2; rLen++) {
            for (int start = 0; start <= rLen; start++) {
                int end = start + ((length - rLen) - 1);
                boolean flag = isPalindrome(chars, start, end);
                if (flag) {
                    StringBuilder buf = new StringBuilder();
                    for (int k = start; k <= end; k++) {
                        buf.append(chars[k]);
                    }
                    return buf.toString();
                }
            }
        }
        return s.substring(0, 1);
    }

    private static boolean isPalindrome(char[] chars, int start, int end) {
        int m = start + (end - start) / 2;
        for (int i = start; i <= m; i++) {
            if (chars[i] != chars[end - (i - start)]) {
                return false;
            }
        }
        return true;
    }

}
