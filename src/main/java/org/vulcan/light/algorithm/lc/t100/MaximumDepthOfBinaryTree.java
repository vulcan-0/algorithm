package org.vulcan.light.algorithm.lc.t100;

import org.vulcan.light.algorithm.zcommon.BTreePrinter;
import org.vulcan.light.algorithm.zcommon.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 *
 * @author Sam Lu
 * @date 2022/06/09
 */
public class MaximumDepthOfBinaryTree {

    /**
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * //     3
     * //    / \
     * //   9  20
     * //     /  \
     * //    15   7
     * 返回它的最大深度 3 。
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        root.setLeft(node1);
        root.setRight(node2);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node2.setLeft(node3);
        node2.setRight(node4);
        BTreePrinter.printNode(root);

        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        System.out.println(maximumDepthOfBinaryTree.maxDepth(root));
        System.out.println(maximumDepthOfBinaryTree.maxDepth2(root));
    }

    /**
     * 深度优先遍历
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root != null) {
            int leftMaxDepth = maxDepth(root.left);
            int rightMaxDepth = maxDepth(root.right);
            maxDepth = Math.max(leftMaxDepth, rightMaxDepth) + 1;
        }
        return maxDepth;
    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }

}
