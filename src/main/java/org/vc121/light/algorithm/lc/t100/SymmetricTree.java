package org.vc121.light.algorithm.lc.t100;

import org.vc121.light.algorithm.zcommon.BinaryTreePrinter;
import org.vc121.light.algorithm.zcommon.TreeNode;

/**
 * 101. 对称二叉树
 * https://leetcode.cn/problems/symmetric-tree/
 *
 * @author Sam Lu
 * @date 2022/06/13
 */
public class SymmetricTree {

    /**
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        BinaryTreePrinter.printNode(root);

        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

}
