package org.vc121.light.algorithm.lc.t70;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * https://leetcode.cn/problems/minimum-window-substring/
 *
 * @author Sam Lu
 * @date 2022/07/13
 */
public class MinimumWindowSubstring {

    /**
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s2 = "bdab";
        String t2 = "ab";
        String s3 = "cabefgecdaecf";
        String t3 = "cae";
        String s4 = "a";
        String t4 = "a";

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow(s, t));
        System.out.println(minimumWindowSubstring.minWindow(s2, t2));
        System.out.println(minimumWindowSubstring.minWindow(s3, t3));
        System.out.println(minimumWindowSubstring.minWindow(s4, t4));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> neededMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            neededMap.put(t.charAt(i), neededMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> countMap = new HashMap<>();
        int minLeft = 0, minRight = 0, minLen = s.length();
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            if (i - left + 1 >= t.length()) {
                int oldLeft = left;
                while (hasEnough(neededMap, countMap)) {
                    countMap.put(s.charAt(left), countMap.get(s.charAt(left)) - 1);
                    left++;
                }
                if (left > oldLeft) {
                    left--;
                    countMap.put(s.charAt(left), countMap.get(s.charAt(left)) + 1);
                }
                if ((right == 0 && hasEnough(neededMap, countMap)) || left > oldLeft) {
                    right = i + 1;
                    if (right - left <= minLen) {
                        minLeft = left;
                        minRight = right;
                        minLen = right - left;
                    }
                }
            }
        }
        if (minRight <= minLeft) {
            return "";
        }
        return s.substring(minLeft, minRight);
    }

    private boolean hasEnough(Map<Character, Integer> neededMap, Map<Character, Integer> countMap) {
        for (Character key : neededMap.keySet()) {
            if (neededMap.get(key) > countMap.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;
    }

}
