package org.vc121.light.algorithm.lc.t200;

import org.vc121.light.algorithm.zcommon.BinaryTreePrinter;
import org.vc121.light.algorithm.zcommon.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author Sam Lu
 * @date 2022/06/30
 */
public class LowestCommonAncestorOfABinaryTree {

    /**
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出：3
     * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node11 = new TreeNode(6);
        TreeNode node12 = new TreeNode(2);
        TreeNode node21 = new TreeNode(0);
        TreeNode node22 = new TreeNode(8);
        TreeNode node121 = new TreeNode(7);
        TreeNode node122 = new TreeNode(4);
        root.setLeft(node1).setRight(node2);
        node1.setLeft(node11).setRight(node12);
        node2.setLeft(node21).setRight(node22);
        node12.setLeft(node121).setRight(node122);
        BinaryTreePrinter.printNode(root);
        TreeNode p = node1;
        TreeNode q = node2;

        LowestCommonAncestorOfABinaryTree lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree();
        TreeNode newNode = lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(root, p, q);
        System.out.println(newNode == null ? "null" : newNode.val);
    }

    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val || root.val == q.val) {
            result = root;
            return true;
        }
        boolean foundLeft = dfs(root.left, p, q);
        boolean foundRight = dfs(root.right, p, q);
        if (foundLeft && foundRight) {
            result = root;
        }
        return foundLeft || foundRight;
    }

}
