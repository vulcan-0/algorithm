package org.vc121.light.algorithm.lc.t150;

/**
 * 155. 最小栈
 * https://leetcode.cn/problems/min-stack/
 *
 * @author Sam Lu
 * @date 2022/06/22
 */
public class MinStack {

    /**
     * 输入：
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     * <p>
     * 输出：
     * [null,null,null,null,-3,null,0,-2]
     * <p>
     * 解释：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     *
     * @param args
     */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    private static class Node {

        private Node next;
        private int val;
        private int minVal;

        public Node(int val) {
            this.val = val;
        }

    }

    private Node head;

    public MinStack() {
        head = new Node(Integer.MAX_VALUE);
        head.minVal = Integer.MAX_VALUE;
    }

    public void push(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        head.minVal = Math.min(head.val, head.next.minVal);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.minVal;
    }

}
