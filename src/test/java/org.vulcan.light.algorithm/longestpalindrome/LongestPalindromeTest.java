package org.vulcan.light.algorithm.longestpalindrome;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 最大回文字符串几种算法的性能测试
 *
 * @author Sam Lu
 * @date 2021/4/18
 */
public class LongestPalindromeTest {

    /**
     * <ol>
     * <li>几种算法当中，中心扩展算法的表现最好，从概率层面讲，出现回文的概率比较低。
     * 在不出现回文的情况下，中心扩展算法的复杂度趋近于O(N)</li>
     * <li>马拉车算法在中心扩展算法的基础上加入了记忆功能，但是貌似有点多余，性能反而变差了。</li>
     * <li>动态规划算法在这里跟枚举算法的性能差不多。</li>
     * </ol>
     *
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "ababababcababababababababcababababababababcabababab";
        String str2 = RandomStringUtils.randomAlphabetic(1000);
        String result = null;

        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            result = ExpandAroundCenter.longestPalindrome(str1);
        }
        System.out.println("中心扩展结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            result = ExpandAroundCenter.longestPalindrome(str2);
        }
        System.out.println("中心扩展结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            result = Manacher.longestPalindrome(str1);
        }
        System.out.println("马拉车结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            result = Manacher.longestPalindrome(str2);
        }
        System.out.println("马拉车结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            result = DynamicProgramming.longestPalindrome(str1);
        }
        System.out.println("动态规划结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            result = DynamicProgramming.longestPalindrome(str2);
        }
        System.out.println("动态规划结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            result = Exhaustive.longestPalindrome(str1);
        }
        System.out.println("枚举结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            result = Exhaustive.longestPalindrome(str2);
        }
        System.out.println("枚举结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");
    }

}
