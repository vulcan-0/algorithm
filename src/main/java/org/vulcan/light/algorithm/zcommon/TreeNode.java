package org.vulcan.light.algorithm.zcommon;

/**
 * @author Sam Lu
 * @date 2022/06/09
 */
public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode setRight(TreeNode right) {
        this.right = right;
        return this;
    }

}
