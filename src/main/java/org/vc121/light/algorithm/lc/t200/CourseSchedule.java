package org.vc121.light.algorithm.lc.t200;

import java.util.*;

/**
 * 207. 课程表
 * https://leetcode.cn/problems/course-schedule/
 *
 * @author Sam Lu
 * @date 2022/07/27
 */
public class CourseSchedule {

    /**
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：true
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
     *
     * @param args
     */
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        int numCourses2 = 2;
        int[][] prerequisites2 = new int[][]{{1, 0}, {0, 1}};

        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(numCourses, prerequisites));
        System.out.println(courseSchedule.canFinish(numCourses2, prerequisites2));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<int[]>> prerequisiteMap = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            List<int[]> prerequisiteList = prerequisiteMap.getOrDefault(prerequisite[1], new ArrayList<>());
            prerequisiteList.add(prerequisite);
            prerequisiteMap.put(prerequisite[1], prerequisiteList);
            inDegrees[prerequisite[0]]++;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                stack.push(i);
            }
        }

        int visited = 0;
        while (!stack.isEmpty()) {
            int course = stack.pop();
            visited++;

            for (int[] prerequisite : prerequisiteMap.getOrDefault(course, new ArrayList<>())) {
                inDegrees[prerequisite[0]]--;
                if (inDegrees[prerequisite[0]] == 0) {
                    stack.push(prerequisite[0]);
                }
            }
        }

        return visited == numCourses;
    }

}
