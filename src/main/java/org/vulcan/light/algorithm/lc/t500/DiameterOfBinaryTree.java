package org.vulcan.light.algorithm.lc.t500;

import org.vulcan.light.algorithm.zcommon.TreeNode;

/**
 * 543. 二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree/
 *
 * @author Sam Lu
 * @date 2022/06/28
 */
public class DiameterOfBinaryTree {

    /**
     * 给定二叉树
     * <p>
     * //          1
     * //         / \
     * //        2   3
     * //       / \
     * //      4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.setLeft(node2).setRight(node3);
        node2.setLeft(node4).setRight(node5);

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(root));
    }

    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = depth(root.left);
        int rightHeight = depth(root.right);
        max = Math.max(max, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
