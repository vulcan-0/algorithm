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
        String s5 = "a";
        String t5 = "aa";

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow(s, t));
        System.out.println(minimumWindowSubstring.minWindow(s2, t2));
        System.out.println(minimumWindowSubstring.minWindow(s3, t3));
        System.out.println(minimumWindowSubstring.minWindow(s4, t4));
        System.out.println(minimumWindowSubstring.minWindow(s5, t5));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> neededMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            neededMap.put(t.charAt(i), neededMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> countMap = new HashMap<>();
        int left = 0, right = 0;
        int minLeft = 0, minRight = -1, minLen = s.length();
        while (right < s.length()) {
            if (neededMap.containsKey(s.charAt(right))) {
                countMap.put(s.charAt(right), countMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            if (right - left + 1 >= t.length()) {
                while (hasEnough(neededMap, countMap)) {
                    if (right - left < minLen) {
                        minLeft = left;
                        minRight = right;
                        minLen = right - left + 1;
                    }
                    if (countMap.containsKey(s.charAt(right))) {
                        countMap.put(s.charAt(left), countMap.getOrDefault(s.charAt(left), 0) - 1);
                    }
                    left++;
                }
            }
            right++;
        }
        return minRight < minLeft ? "" : s.substring(minLeft, minRight + 1);
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
