package com.company.BackTracking;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*输入两个数字 `n, k`，算法输出 `[1..n]` 中 k 个数字的所有组合。

比如输入 `n = 4, k = 2`，输出如下结果，顺序无所谓，但是不能包含重复（按照组合的定义，`[1,2]` 和 `[2,1]` 也算重复）：

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4]
]*/
public class ZuHe {
    static List<List<Integer>> result = new LinkedList<>();
    public static void main(String[] args) {
        Zuhe(4,2);
        System.out.println(result);
    }
    public static void Zuhe(int n, int k){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        process(arr,0,k,new LinkedList<>());
    }
    public static void process(int[]arr,int tem, int k,LinkedList<Integer> list){
        if(list.size() == k){
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = tem; i < arr.length; i++) {
            list.addLast(arr[i]);
            process(arr,i+1,k,list);
            list.removeLast();
        }
    }

}
