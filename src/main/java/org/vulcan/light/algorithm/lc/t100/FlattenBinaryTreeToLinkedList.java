package org.vulcan.light.algorithm.lc.t100;

import org.vulcan.light.algorithm.zcommon.BinaryTreePrinter;
import org.vulcan.light.algorithm.zcommon.TreeNode;

/**
 * 114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 *
 * @author Sam Lu
 * @date 2022/07/01
 */
public class FlattenBinaryTreeToLinkedList {

    /**
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node11 = new TreeNode(3);
        TreeNode node12 = new TreeNode(4);
        TreeNode node22 = new TreeNode(6);
        root.setLeft(node1).setRight(node2);
        node1.setLeft(node11).setRight(node12);
        node2.setRight(node22);
        BinaryTreePrinter.printNode(root);

        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        flattenBinaryTreeToLinkedList.flatten(root);
        BinaryTreePrinter.printNode(root);

        // [1,null,2,3]
        TreeNode root2 = new TreeNode(1);
        TreeNode nodeT22 = new TreeNode(2);
        TreeNode nodeT221 = new TreeNode(3);
        root2.setRight(nodeT22);
        nodeT22.setLeft(nodeT221);
        BinaryTreePrinter.printNode(root2);
        flattenBinaryTreeToLinkedList.flatten(root2);
        BinaryTreePrinter.printNode(root2);
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if (root.left != null) {
            TreeNode leftLast = root.left;
            while (leftLast.right != null) {
                leftLast = leftLast.right;
            }
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

}
