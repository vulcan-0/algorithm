package org.vulcan.light.algorithm.lc.t90;

import org.vulcan.light.algorithm.zcommon.BinaryTreePrinter;
import org.vulcan.light.algorithm.zcommon.TreeNode;

/**
 * 98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/
 *
 * @author Sam Lu
 * @date 2022/06/18
 */
public class ValidateBinarySearchTree {

    /**
     * 输入：root = [2,1,3]
     * 输出：true
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.setLeft(node1);
        root.setRight(node2);
        BinaryTreePrinter.printNode(root);

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.isValidBST(root));

        // [120,70,140,50,100,130,160,20,55,75,110,119,135,150,200]
        TreeNode root2 = new TreeNode(120);
        TreeNode root21 = new TreeNode(70);
        TreeNode root22 = new TreeNode(140);
        TreeNode root211 = new TreeNode(50);
        TreeNode root212 = new TreeNode(100);
        TreeNode root221 = new TreeNode(130);
        TreeNode root222 = new TreeNode(160);
        TreeNode root2111 = new TreeNode(20);
        TreeNode root2112 = new TreeNode(55);
        TreeNode root2121 = new TreeNode(75);
        TreeNode root2122 = new TreeNode(110);
        TreeNode root2211 = new TreeNode(119);
        TreeNode root2212 = new TreeNode(135);
        TreeNode root2221 = new TreeNode(150);
        TreeNode root2222 = new TreeNode(200);
        root2.setLeft(root21);
        root2.setRight(root22);
        root21.setLeft(root211);
        root21.setRight(root212);
        root22.setLeft(root221);
        root22.setRight(root222);
        root211.setLeft(root2111);
        root211.setRight(root2112);
        root212.setLeft(root2121);
        root212.setRight(root2122);
        root221.setLeft(root2211);
        root221.setRight(root2212);
        root222.setLeft(root2221);
        root222.setRight(root2222);
        BinaryTreePrinter.printNode(root2);

        System.out.println(validateBinarySearchTree.isValidBST(root2));
    }

    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode root, long min, long max) {
        boolean isValid = true;
        if (root.left != null) {
            isValid = root.left.val < root.val
                    && root.left.val > min
                    && check(root.left, min, root.val);
        }
        if (root.right != null) {
            isValid = isValid
                    && root.right.val > root.val
                    && root.right.val < max
                    && check(root.right, root.val, max);
        }
        return isValid;
    }

}
