package com.Algorithm.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

public class N90_SubSet_NoRepeat {
    //set放在最后过滤 不剪枝
    //剪枝看N47_Pailie

    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return new ArrayList(set);
    }
    void dfs(int[] nums, int idx, List<Integer> path) {
        if (idx <= nums.length) set.add(new ArrayList<>(path));
        else return;

        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

}
