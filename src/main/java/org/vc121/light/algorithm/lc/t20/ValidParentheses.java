package org.vc121.light.algorithm.lc.t20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/
 *
 * @author Sam Lu
 * @date 2022/6/4
 */
public class ValidParentheses {

    /**
     * 输入：s = "()"
     * 输出：true
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "()";

        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(s));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || !stack.peek().equals(map.get(s.charAt(i)))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

}
