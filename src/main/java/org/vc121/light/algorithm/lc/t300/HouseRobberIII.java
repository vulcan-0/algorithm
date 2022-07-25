package org.vc121.light.algorithm.lc.t300;

import org.vc121.light.algorithm.zcommon.BinaryTreePrinter;
import org.vc121.light.algorithm.zcommon.TreeNode;

/**
 * 337. 打家劫舍 III
 * https://leetcode.cn/problems/house-robber-iii/
 *
 * @author Sam Lu
 * @date 2022/07/25
 */
public class HouseRobberIII {

    /**
     * 输入: root = [3,2,3,null,3,null,1]
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node12 = new TreeNode(3);
        TreeNode node22 = new TreeNode(1);
        root.setLeft(node1).setRight(node2);
        node1.setRight(node12);
        node2.setRight(node22);
        BinaryTreePrinter.printNode(root);

        HouseRobberIII houseRobberIII = new HouseRobberIII();
        System.out.println(houseRobberIII.rob(root));
    }

    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[2];
        int[] result = new int[2];
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        // int[0]表示不打劫node的请求，int[1]表示打劫node的情况
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + node.val;
        return result;
    }

}
