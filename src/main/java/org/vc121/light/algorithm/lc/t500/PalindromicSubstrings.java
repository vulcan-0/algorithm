package org.vc121.light.algorithm.lc.t500;

/**
 * 647. 回文子串
 * https://leetcode.cn/problems/palindromic-substrings/
 *
 * @author Sam Lu
 * @date 2022/07/15
 */
public class PalindromicSubstrings {

    /**
     * 输入：s = "abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "abc";
        String s1 = "aaa";
        String s2 = "aaaaa";

        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        System.out.println(palindromicSubstrings.countSubstrings(s));
        System.out.println(palindromicSubstrings.countSubstrings(s1));
        System.out.println(palindromicSubstrings.countSubstrings(s2));
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = centerExpand(s, i, i);
            int even = centerExpand(s, i, i + 1);
            count++;
            if (odd > 1) count += (odd - 1) / 2;
            if (even > 1) count += even / 2;
        }
        return count;
    }

    private int centerExpand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
