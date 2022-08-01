package org.vc121.light.algorithm.lc.t300;

import org.vc121.light.algorithm.zcommon.BinaryTreePrinter;
import org.vc121.light.algorithm.zcommon.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * https://leetcode.cn/problems/path-sum-iii/
 *
 * @author Sam Lu
 * @date 2022/08/01
 */
public class PathSumIII {

    /**
     * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
     * 输出：3
     * 解释：和等于 8 的路径有 3 条，如图所示。
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node11 = new TreeNode(3);
        TreeNode node12 = new TreeNode(2);
        TreeNode node22 = new TreeNode(11);
        TreeNode node111 = new TreeNode(3);
        TreeNode node112 = new TreeNode(-2);
        TreeNode node122 = new TreeNode(1);
        root.setLeft(node1).setRight(node2);
        node1.setLeft(node11).setRight(node12);
        node2.setRight(node22);
        node11.setLeft(node111).setRight(node112);
        node12.setRight(node122);
        BinaryTreePrinter.printNode(root);
        int targetSum = 8;

        PathSumIII pathSumIII = new PathSumIII();
        System.out.println(pathSumIII.pathSum(root, targetSum));

        // [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
        // 0
        TreeNode root2 = new TreeNode(1000000000);
        TreeNode n1 = new TreeNode(1000000000);
        TreeNode n11 = new TreeNode(294967296);
        TreeNode n111 = new TreeNode(1000000000);
        TreeNode n1111 = new TreeNode(1000000000);
        TreeNode n11111 = new TreeNode(1000000000);
        root2.setLeft(n1);
        n1.setLeft(n11);
        n11.setLeft(n111);
        n111.setLeft(n1111);
        n1111.setLeft(n11111);
        BinaryTreePrinter.printNode(root2);
        int targetSum2 = 0;
        System.out.println(pathSumIII.pathSum(root2, targetSum2));
    }

    private Map<Long, Integer> prefixSumMap = new HashMap<>();
    private long prefixSum = 0;

    {
        prefixSumMap.put(0L, 1);
    }

    /**
     * 前缀和
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        prefixSum += root.val;
        if (prefixSumMap.containsKey(prefixSum - targetSum)) {
            count += prefixSumMap.get(prefixSum - targetSum);
        }
        prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);
        prefixSumMap.put(prefixSum, prefixSumMap.get(prefixSum) - 1);
        prefixSum -= root.val;
        return count;
    }

}
