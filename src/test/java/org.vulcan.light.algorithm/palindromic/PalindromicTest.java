package org.vulcan.light.algorithm.palindromic;

/**
 * 最大回文字符串三种算法的性能测试
 *
 * @author luxiaocong
 * @createdOn 2021/4/18
 */
public class PalindromicTest {

    /**
     * <ol>
     * <li>中心扩展算法是一种比较取巧的算法，从概率层面讲，出现回文的概率是比较小的，
     * 在不出现回文的情况下，中心扩展算法的复杂度趋近于O(N)</li>
     * <li>可能是写法原因，导致动态规划执行了更多操作，消耗了更多性能，在大面积回文的字符串中，
     * 中心扩展算法的效率还是比动态规划高</li>
     * <li>马拉车在中心扩展算法的基础上加入了记忆功能，但是貌似有点多余，性能反而变差了</li>
     * </ol>
     *
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww";
        String str2 = "sdfsjlfaslfjlsjfihxcvsjofsjflsdfddffdsfjaiosjfiosfjasfjjjk";
        String result = null;

        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            result = DynamicProgramming.longestPalindrome(str1);
        }
        System.out.println("动态规划结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            result = DynamicProgramming.longestPalindrome(str2);
        }
        System.out.println("动态规划结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            result = ExpandAroundCenter.longestPalindrome(str1);
        }
        System.out.println("中心扩展结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            result = ExpandAroundCenter.longestPalindrome(str2);
        }
        System.out.println("中心扩展结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            result = Manacher.longestPalindrome(str1);
        }
        System.out.println("马拉车结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            result = Manacher.longestPalindrome(str2);
        }
        System.out.println("马拉车结果：" + result + "，耗时：" + (System.currentTimeMillis() - time) + "ms");
    }

}
