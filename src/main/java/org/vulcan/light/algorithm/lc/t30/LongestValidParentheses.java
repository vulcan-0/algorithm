package org.vulcan.light.algorithm.lc.t30;

/**
 * 32. 最长有效括号
 * https://leetcode.cn/problems/longest-valid-parentheses/
 *
 * @author Sam Lu
 * @date 2022/06/27
 */
public class LongestValidParentheses {

    /**
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "(()";

        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        int leftCount = 0, rightCount = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (rightCount > leftCount) {
                leftCount = rightCount = 0;
            } else if (leftCount == rightCount) {
                maxLen = Math.max(maxLen, rightCount);
            }
        }
        leftCount = rightCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (rightCount < leftCount) {
                leftCount = rightCount = 0;
            } else if (leftCount == rightCount) {
                maxLen = Math.max(maxLen, rightCount);
            }
        }
        return maxLen * 2;
    }

}
