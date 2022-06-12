package org.vulcan.light.algorithm.lc.t20;

import org.vulcan.light.algorithm.zcommon.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode.cn/problems/generate-parentheses/
 *
 * @author Sam Lu
 * @date 2022/06/10
 */
public class GenerateParentheses {

    /**
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 3;

        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> result = generateParentheses.generateParenthesis(n);
        Printer.printList(result);
    }

    public List<String> generateParenthesis(int n) {
        List<String> collection = new ArrayList<>();
        backtrace(collection, 0, 0, n, new StringBuilder());
        return collection;
    }

    /**
     * 回溯算法
     *
     * @param collection
     * @param left
     * @param right
     * @param max
     * @param builder
     */
    private void backtrace(List<String> collection, int left, int right, int max, StringBuilder builder) {
        if (right == max) {
            collection.add(builder.toString());
            return;
        }
        if (left < max) {
            builder.append("(");
            backtrace(collection, left + 1, right, max, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right < left) {
            builder.append(")");
            backtrace(collection, left, right + 1, max, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
