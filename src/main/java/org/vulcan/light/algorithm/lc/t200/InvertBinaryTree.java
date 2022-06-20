package org.vulcan.light.algorithm.lc.t200;

import org.vulcan.light.algorithm.zcommon.BinaryTreePrinter;
import org.vulcan.light.algorithm.zcommon.TreeNode;

/**
 * 226. 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/
 *
 * @author Sam Lu
 * @date 2022/06/20
 */
public class InvertBinaryTree {

    /**
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(3);
        TreeNode node21 = new TreeNode(6);
        TreeNode node22 = new TreeNode(9);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node11);
        node1.setRight(node12);
        node2.setLeft(node21);
        node2.setRight(node22);
        BinaryTreePrinter.printNode(root);

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode newNode = invertBinaryTree.invertTree(root);
        BinaryTreePrinter.printNode(newNode);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

}
