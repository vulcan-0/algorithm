package org.vc121.light.algorithm.lc.t100;

import org.vc121.light.algorithm.zcommon.BinaryTreePrinter;
import org.vc121.light.algorithm.zcommon.Printer;
import org.vc121.light.algorithm.zcommon.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 *
 * @author Sam Lu
 * @date 2022/06/11
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[9,20],[15,7]]
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
        BinaryTreePrinter.printNode(root);

        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = binaryTreeLevelOrderTraversal.levelOrder(root);
        Printer.printList(result);
    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

}
