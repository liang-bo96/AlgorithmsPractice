package com.company.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class N39_Combination_Sum {
    public static void main(String[] args) {
        int[] tem = new int[]{ 3, 4, 5,6,7};
        N39_Combination_Sum sum = new N39_Combination_Sum();
        System.out.println(sum.combinationSum(tem, 30));
        System.out.println(sum.combinationSum2(tem, 30));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        process(candidates, 0, target, new ArrayList<>());
        return result;
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static void process(int[] candidate, int location, int target, List<Integer> list) {
        if (location == candidate.length) {
            if (target == 0) {
                result.add(list);
            }
            return;
        }
        for (int i = 0; i * candidate[location] <= target; i++) {
            for (int j = 0; j < i; j++) {
                list.add(candidate[location]);
            }
            process(candidate, location + 1, target - i * candidate[location], new ArrayList<>(list));
            for (int j = 0; j < i; j++) {
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

}
