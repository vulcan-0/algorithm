package org.vulcan.light.algorithm.lc.t90;

import org.vulcan.light.algorithm.zcommon.BinaryTreePrinter;
import org.vulcan.light.algorithm.zcommon.Printer;
import org.vulcan.light.algorithm.zcommon.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 *
 * @author Sam Lu
 * @date 2022/06/15
 */
public class BinaryTreeInorderTraversal {

    /**
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.setRight(node1);
        node1.setLeft(node2);
        BinaryTreePrinter.printNode(root);

        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> result = binaryTreeInorderTraversal.inorderTraversal(root);
        Printer.printList(result);
    }

    /**
     * 莫里斯（Morris）遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode x = root, predessor;
        while (x != null) {
            if (x.left == null) {
                result.add(x.val);
                x = x.right;
            } else {
                predessor = x.left;
                while (predessor.right != null && predessor.right != x) {
                    predessor = predessor.right;
                }
                if (predessor.right == null) {
                    predessor.right = x;
                    x = x.left;
                } else {
                    result.add(x.val);
                    predessor.right = null;
                    x = x.right;
                }
            }
        }
        return result;
    }

}
