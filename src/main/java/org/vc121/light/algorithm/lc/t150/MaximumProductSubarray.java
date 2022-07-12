package org.vc121.light.algorithm.lc.t150;

/**
 * 152. 乘积最大子数组
 * https://leetcode.cn/problems/maximum-product-subarray/
 *
 * @author Sam Lu
 * @date 2022/07/08
 */
public class MaximumProductSubarray {

    /**
     * 输入: nums = [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        int[] nums2 = new int[]{-4, -3, -2};

        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(nums));
        System.out.println(maximumProductSubarray.maxProduct(nums2));
    }

    /**
     * 滚动数组
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = nums[0], maxF = nums[0], minF = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMaxF = maxF;
            maxF = Math.max(nums[i], Math.max(maxF * nums[i], minF * nums[i]));
            minF = Math.min(nums[i], Math.min(tempMaxF * nums[i], minF * nums[i]));
            max = Math.max(max, maxF);
        }
        return max;
    }

}
