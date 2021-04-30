package org.vulcan.light.algorithm.longestpalindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文字子串 - 马拉车算法
 *
 * @author Sam Lu
 * @date 2021/4/18
 */
public class Manacher {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        StringBuilder buf = new StringBuilder("#");
        for (int i = 0; i < chars.length; i++) {
            buf.append(chars[i]);
            buf.append("#");
        }
        chars = buf.toString().toCharArray();

        Map<Integer, Integer> lenMap = new HashMap();
        int start = 0, end = 0;
        int j = -1, right = -1;
        for (int i = 0; i < chars.length; i++) {
            int len;
            if (right > i) {
                int ll = Math.min(lenMap.get(2 * j - i), right - i);
                len = expand(chars, i - ll, i + ll);
            } else {
                len = expand(chars, i, i);
            }
            lenMap.put(i, len);

            if (i + len > right) {
                j = i;
                right = j + len;
            }

            if (len > (end - start) / 2) {
                start = i - len;
                end = i + len;
            }
        }
        return s.substring(start / 2, end / 2);
    }

    private static int expand(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return (right - left - 2) / 2;
    }

}
