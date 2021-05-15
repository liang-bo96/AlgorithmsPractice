package com.company.Leetcode;

import java.util.*;

public class N56 {
    public static void main(String[] args) {
        int[][] tem = new int[][]{{2,3},{4,5},{1,10}};
        System.out.println(merge(tem));
    }
    public static int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        for(int i = 0 ; i < intervals.length;i++){
            queue.add(intervals[i]);
        }
        List<int[]> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int[] tem = queue.poll();
            if(!queue.isEmpty() && tem[1] >= queue.peek()[0]){
                int[] a = queue.poll();
                queue.add(new int[]{tem[0] > a[0] ? a[0] : tem[0],a[1]});
            }else{
                res.add(tem);
            }
        }
        int[][] result = new int[res.size()][2];
        for(int i = 0 ; i < res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
