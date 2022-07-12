package org.vc121.light.algorithm.lc.t700;

import org.vc121.light.algorithm.zcommon.Printer;

import java.util.Stack;

/**
 * 739. 每日温度
 * https://leetcode.cn/problems/daily-temperatures/
 *
 * @author Sam Lu
 * @date 2022/06/24
 */
public class DailyTemperatures {

    /**
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] result = dailyTemperatures.dailyTemperatures(temperatures);
        Printer.printArray(result);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperature) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

}
