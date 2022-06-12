package org.vulcan.light.algorithm.lc.t10;

import org.vulcan.light.algorithm.zcommon.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 *
 * @author Sam Lu
 * @date 2022/06/08
 */
public class LetterCombinationsOfAPhoneNumber {

    /**
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *
     * @param args
     */
    public static void main(String[] args) {
        String digits = "23";

        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        List<String> result = letterCombinationsOfAPhoneNumber.letterCombinations(digits);
        Printer.printList(result);
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> letterMap = new HashMap<>(10);
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");
        List<String> combinations = new ArrayList<>();
        StringBuilder combination = new StringBuilder();
        int index = 0;
        backtrace(combinations, letterMap, digits, index, combination);
        return combinations;
    }

    /**
     * 回溯算法
     *
     * @param combinations
     * @param letterMap
     * @param digits
     * @param index
     * @param combination
     */
    private void backtrace(List<String> combinations, Map<Character, String> letterMap, String digits, int index, StringBuilder combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            String letters = letterMap.get(digits.charAt(index));
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                backtrace(combinations, letterMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}
