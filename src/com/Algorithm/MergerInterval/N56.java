package com.Algorithm.MergerInterval;
/*
*
* 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

 

示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
import java.util.*;

public class N56 {
    public static void main(String[] args) {
        int[][] tem = new int[][]{{1,3},{2,6},{8,10},{11,12}};
        System.out.println(Arrays.deepToString(merge1(tem)));
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> tem = new ArrayList<>();
        for(int i = 0 ; i < intervals.length;i++){
            if(i == 0){
                tem.add(intervals[i]);
                continue;
            }
            if(intervals[i][0] <= tem.get(tem.size()-1)[1]){
                int[] last = tem.remove(tem.size()-1);
                tem.add(new int[]{last[0],Math.max(last[1],intervals[i][1])});
            }else{
                tem.add(intervals[i]);
            }
        }
        int[][] result = new int[tem.size()][2];
        for(int i = 0 ; i < tem.size(); i++){
            result[i] = tem.get(i);
        }
        return result;
    }

    //practice
    public static int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        List<List<Integer>> l = new ArrayList<>();
        int i = 0;
        while (i < intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i < intervals.length && intervals[i][0] <= right){
                right = Math.max(right,intervals[i][1]);
                i++;
            }
            l.add(Arrays.asList(left,right));
        }
        int[][] result = new int[l.size()][2];
        for(i  = 0; i < l.size(); i++){
            result[i][0] = l.get(i).get(0);
            result[i][1] = l.get(i).get(1);
        }
        return result;
    }
}
