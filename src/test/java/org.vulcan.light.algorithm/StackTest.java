package org.vulcan.light.algorithm;

import java.util.Stack;

/**
 * @author luxiaocong
 * @createdOn 2021/4/17
 */
public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }

}
