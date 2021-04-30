package org.vulcan.light.algorithm.tree.avl;

/**
 * AVL树
 *
 * @author Sam Lu
 * @date 2021/4/28
 */
public class AvlTree<T extends Comparable> {

    private AvlTreeNode root;

    public AvlTree() {
    }

    /**
     * 插入节点
     *
     * @param value
     */
    public void insert(T value) {
        assertNotNull(value);
        if (root == null) {
            root = new AvlTreeNode(null, value);
        } else {
            insertAvlTreeNode(root, value);
        }
    }

    /**
     * 删除节点
     *
     * @param value
     */
    public void delete(T value) {
        assertNotNull(value);
        deleteAvlTreeNode(root, value);
    }

    private AvlTreeNode insertAvlTreeNode(AvlTreeNode node, T value) {
        if (value.compareTo(node.value) < 0) {
            if (node.left == null) {
                node.left = new AvlTreeNode(node, value);
                node.left.isLeft = true;
                resetHeight(node);
            } else {
                insertAvlTreeNode(node.left, value);
            }
        } else if (value.compareTo(node.value) > 0) {
            if (node.right == null) {
                node.right = new AvlTreeNode(node, value);
                node.right.isRight = true;
                resetHeight(node);
            } else {
                insertAvlTreeNode(node.right, value);
            }
        }

        if (!balance(node)) {
            rotate(node);
        }
        return node;
    }

    private AvlTreeNode deleteAvlTreeNode(AvlTreeNode node, T value) {
        if (node == null) {
            return null;
        }

        AvlTreeNode beAffectedNode = null;
        if (value.compareTo(node.value) < 0) {
            beAffectedNode = deleteAvlTreeNode(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            beAffectedNode = deleteAvlTreeNode(node.right, value);
        } else if (value == node.value) {
            beAffectedNode = deleteAvlTreeNode(node);
        }

        if (beAffectedNode == null) {
            return null;
        }
        if (!balance(beAffectedNode)) {
            rotate(beAffectedNode);
        }
        return beAffectedNode.parent;
    }

    private AvlTreeNode deleteAvlTreeNode(AvlTreeNode node) {
        if (node.left == null && node.right == null) {
            replaceAvlTreeNode(node, null);
        } else if (node.left == null) {
            replaceAvlTreeNode(node, node.right);
        } else if (node.right == null) {
            replaceAvlTreeNode(node, node.left);
        } else {
            AvlTreeNode minRightNode = node.right;
            while (minRightNode.left != null) {
                minRightNode = minRightNode.left;
            }
            AvlTreeNode beAffectedNode = minRightNode.parent;
            replaceAvlTreeNode(minRightNode, null);
            replaceAvlTreeNode(node, minRightNode);
            resetHeight(minRightNode);
            return beAffectedNode;
        }
        return node.parent;
    }

    private void replaceAvlTreeNode(AvlTreeNode current, AvlTreeNode node) {
        if (current.isLeft) {
            current.parent.left = node;
        } else if (current.isRight) {
            current.parent.right = node;
        } else {
            root = node;
        }
        if (node != null) {
            node.isLeft = current.isLeft;
            node.isRight = current.isRight;
            node.parent = current.parent;
            node.left = current.left;
            node.right = current.right;
        }
        resetHeight(current.parent);
    }

    private boolean balance(AvlTreeNode node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) < 2;
    }

    private void rotate(AvlTreeNode node) {
        if (height(node.left) > height(node.right)) {
            if (height(node.left.left) > height(node.left.right)) {
                leftLeftRotate(node, node.left);
            } else {
                leftRightRotate(node, node.left);
            }
        } else {
            if (height(node.right.left) > height(node.right.right)) {
                rightLeftRotate(node, node.right);
            } else {
                rightRightRotate(node, node.right);
            }
        }
    }

    private int height(AvlTreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private void leftRightRotate(AvlTreeNode parent, AvlTreeNode left) {
        parent.left = left.right;
        left.right.parent = parent;
        changeSide(left.right);
        if (left.right.left != null) {
            AvlTreeNode tmp = left.right.left;
            left.right = tmp;
            tmp.parent = left;
            changeSide(tmp);
        }
        parent.left.left = left;
        left.parent = parent.left;
        resetHeight(left);
        leftLeftRotate(parent, parent.left);
    }

    private void leftLeftRotate(AvlTreeNode parent, AvlTreeNode left) {
        parent.left = left.left;
        left.left.parent = parent;
        if (left.left.right != null) {
            AvlTreeNode tmp = left.left.right;
            left.left = tmp;
            tmp.parent = left;
            changeSide(tmp);
        }
        parent.left.right = left;
        left.parent = parent.left;
        changeSide(left);
        resetHeight(left);
    }

    private void rightLeftRotate(AvlTreeNode parent, AvlTreeNode right) {
        parent.right = right.left;
        right.left.parent = parent;
        changeSide(right.left);
        if (right.left.right != null) {
            AvlTreeNode tmp = right.left.right;
            right.left = tmp;
            tmp.parent = right;
            changeSide(tmp);
        }
        parent.right.right = right;
        right.parent = parent.right;
        resetHeight(right);
        rightRightRotate(parent, parent.right);
    }

    private void rightRightRotate(AvlTreeNode parent, AvlTreeNode right) {
        parent.right = right.right;
        right.right.parent = parent;
        if (right.right.left != null) {
            AvlTreeNode tmp = right.right.left;
            right.right = tmp;
            tmp.parent = right;
            changeSide(tmp);
        }
        parent.right.left = right;
        right.parent = parent.right;
        changeSide(right);
        resetHeight(right);
    }

    private void changeSide(AvlTreeNode node) {
        node.isLeft = !node.isLeft;
        node.isRight = !node.isRight;
    }

    private void resetHeight(AvlTreeNode parent) {
        while (parent != null) {
            int oldParentHeight = parent.height;
            parent.height = Math.max(parent.left != null ? parent.left.height : 0,
                    parent.right != null ? parent.right.height : 0) + 1;
            if (parent.height == oldParentHeight) {
                break;
            }
            parent = parent.parent;
        }
    }

    private void assertNotNull(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value must not be null!");
        }
    }

    public class AvlTreeNode {

        private T value;
        private int height;
        private boolean isLeft;
        private boolean isRight;
        private AvlTreeNode parent;
        private AvlTreeNode left;
        private AvlTreeNode right;

        public AvlTreeNode(AvlTreeNode parent, T value) {
            this.parent = parent;
            this.value = value;
            this.height = 1;
            resetHeight(parent);
        }

    }

}
