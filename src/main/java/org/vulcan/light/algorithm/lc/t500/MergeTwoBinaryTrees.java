package org.vulcan.light.algorithm.lc.t500;

import org.vulcan.light.algorithm.zcommon.BinaryTreePrinter;
import org.vulcan.light.algorithm.zcommon.TreeNode;

/**
 * 617. 合并二叉树
 * https://leetcode.cn/problems/merge-two-binary-trees/
 *
 * @author Sam Lu
 * @date 2022/07/07
 */
public class MergeTwoBinaryTrees {

    /**
     * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
     * 输出：[3,4,5,5,4,null,7]
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node11 = new TreeNode(3);
        TreeNode node12 = new TreeNode(2);
        TreeNode node111 = new TreeNode(5);
        root1.setLeft(node11).setRight(node12);
        node11.setLeft(node111);
        BinaryTreePrinter.printNode(root1);

        TreeNode root2 = new TreeNode(2);
        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(3);
        TreeNode node212 = new TreeNode(4);
        TreeNode node222 = new TreeNode(7);
        root2.setLeft(node21).setRight(node22);
        node21.setRight(node212);
        node22.setRight(node222);
        BinaryTreePrinter.printNode(root2);

        MergeTwoBinaryTrees mergeTwoBinaryTrees = new MergeTwoBinaryTrees();
        TreeNode newNode = mergeTwoBinaryTrees.mergeTrees(root1, root2);
        BinaryTreePrinter.printNode(newNode);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        newRoot.left = mergeTrees(root1.left, root2.left);
        newRoot.right = mergeTrees(root1.right, root2.right);
        return newRoot;
    }

}
