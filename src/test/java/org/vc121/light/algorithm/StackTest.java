package org.vc121.light.algorithm;

import java.util.Stack;

/**
 * 栈的常用方法
 *
 * @author Sam Lu
 * @date 2021/4/17
 */
public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        // print C
        System.out.println(stack.pop());
        // print B
        System.out.println(stack.pop());
        // print A
        System.out.println(stack.peek());
        // print A
        System.out.println(stack.peek());
        // print A
        System.out.println(stack.pop());
        // print 0
        System.out.println(stack.size());
    }

}
