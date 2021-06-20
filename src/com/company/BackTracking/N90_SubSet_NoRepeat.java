package com.company.BackTracking;

import com.sun.xml.internal.ws.api.ha.HaInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.*;

public class N90_SubSet_NoRepeat {
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
