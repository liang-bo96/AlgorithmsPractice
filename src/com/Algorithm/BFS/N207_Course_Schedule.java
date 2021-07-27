package com.Algorithm.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*207. 课程表
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。



示例 1：

输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
示例 2：

输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false
解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。


提示：

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
prerequisites[i] 中的所有课程对 互不相同*/
public class N207_Course_Schedule {
    public static void main(String[] args) {
        System.out.println(new N207_Course_Schedule().canFinish(2, new int[][]{{0, 1}}));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new LinkedList<>();
        int[] indegree = new int[numCourses];
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new LinkedList<>());
        }
        for(int[] tem : prerequisites){
            indegree[tem[0]]++;
            list.get(tem[1]).add(tem[0]);
        }
        for(int i = 0 ; i < indegree.length;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        List<Integer> result = new LinkedList<>();
        while(!queue.isEmpty()){
            Integer cur = queue.poll();
            result.add(cur);
            List<Integer> cur_next = list.get(cur);
            for(int i : cur_next){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        return result.size() == numCourses;
    }
}
