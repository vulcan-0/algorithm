package org.vulcan.light.algorithm.tree.avl;

/**
 * @author Sam Lu
 * @date 2021/4/30
 */
public class AvlTreeTest {

    public static void main(String[] args) {
        AvlTree<Integer> avlTree = new AvlTree<Integer>();
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(5);
        System.out.println(avlTree);

        avlTree.delete(1);
        avlTree.delete(2);
        avlTree.delete(3);
        avlTree.delete(4);
        avlTree.delete(5);
        System.out.println(avlTree);
    }

}
