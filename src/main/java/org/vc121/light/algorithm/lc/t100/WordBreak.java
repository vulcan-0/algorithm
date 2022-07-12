package org.vc121.light.algorithm.lc.t100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * https://leetcode.cn/problems/word-break/
 *
 * @author Sam Lu
 * @date 2022/07/12
 */
public class WordBreak {

    /**
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordDict = new String[]{"leet", "code"};

        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(s, Arrays.asList(wordDict)));
    }

    private Set<String> failSet = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        Set<String> wordSet = new HashSet<>(wordDict);
        if (failSet.contains(s)) {
            return false;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (wordSet.contains(s.substring(0, i)) && wordBreak(s.substring(i), wordDict)) {
                return true;
            }
        }
        failSet.add(s);
        return false;
    }

}
