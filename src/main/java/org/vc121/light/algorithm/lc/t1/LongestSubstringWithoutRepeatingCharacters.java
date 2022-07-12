package org.vc121.light.algorithm.lc.t1;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 *
 * @author Sam Lu
 * @date 2022/6/4
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "abcabcbb";

        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters =
                new LongestSubstringWithoutRepeatingCharacters();
        int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0, right = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(map.get(s.charAt(i)) + 1, left);
            }
            map.put(s.charAt(i), i);
            right++;
            max = Math.max(right - left, max);
        }
        return max;
    }

}
