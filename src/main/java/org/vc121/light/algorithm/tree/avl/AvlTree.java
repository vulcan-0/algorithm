package org.vc121.light.algorithm.tree.avl;

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
     * @param key
     */
    public void insert(T key) {
        assertNotNull(key);
        root = insert(root, key);
    }

    /**
     * 删除节点
     *
     * @param key
     */
    public void delete(T key) {
        assertNotNull(key);
        root = delete(root, key);
    }

    /**
     * 查询节点
     *
     * @param key
     * @return
     */
    public AvlTreeNode find(T key) {
        assertNotNull(key);
        AvlTreeNode current = root;
        while (current != null) {
            if (key.equals(current.key)) {
                return current;
            }
            current = key.compareTo(current.key) < 0 ? current.left : current.right;
        }
        return null;
    }

    private AvlTreeNode insert(AvlTreeNode node, T key) {
        if (node == null) {
            return new AvlTreeNode(key);
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insert(node.right, key);
        } else {
            throw new IllegalArgumentException("Duplicate Key!");
        }
        return reBalance(node);
    }

    private AvlTreeNode delete(AvlTreeNode node, T key) {
        if (node == null) {
            return null;
        } else if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = node.left != null ? node.left : node.right;
            } else {
                AvlTreeNode mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = reBalance(node);
        }
        return node;
    }

    private AvlTreeNode mostLeftChild(AvlTreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private AvlTreeNode reBalance(AvlTreeNode node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (height(node.left.left) > height(node.left.right)) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (balance < -1) {
            if (height(node.right.right) > height(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        return node;
    }

    private AvlTreeNode rotateRight(AvlTreeNode y) {
        AvlTreeNode x = y.left;
        AvlTreeNode z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private AvlTreeNode rotateLeft(AvlTreeNode y) {
        AvlTreeNode x = y.right;
        AvlTreeNode z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void assertNotNull(T key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must not be null!");
        }
    }

    private void updateHeight(AvlTreeNode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private int height(AvlTreeNode node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(AvlTreeNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    public class AvlTreeNode {

        private T key;
        private int height;
        private AvlTreeNode left;
        private AvlTreeNode right;

        public AvlTreeNode(T key) {
            this.key = key;
            this.height = 1;
        }

        public T getKey() {
            return key;
        }

    }

}
