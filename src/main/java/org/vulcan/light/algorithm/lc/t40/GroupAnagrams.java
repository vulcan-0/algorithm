package org.vulcan.light.algorithm.lc.t40;

import org.vulcan.light.algorithm.zcommon.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 * https://leetcode.cn/problems/group-anagrams/
 *
 * @author Sam Lu
 * @date 2022/06/27
 */
public class GroupAnagrams {

    /**
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);
        Printer.printList(result);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> listMap = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            StringBuilder buf = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                buf.append((char) ('a' + i));
                buf.append(count[i]);
            }
            String key = buf.toString();
            List<String> list = listMap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            listMap.put(key, list);
        }
        return new ArrayList<>(listMap.values());
    }

}
