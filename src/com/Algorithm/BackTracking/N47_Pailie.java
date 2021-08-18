package com.Algorithm.BackTracking;

import java.util.*;

import static com.Algorithm.Leetcode.N46.swap;

public class N47_Pailie {
    public static void main(String[] args) {
        System.out.println(new N47_Pailie().permuteUnique(new int[]{1, 3, 2}));
        System.out.println(new N47_Pailie().permuteUnique1(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        return permute(nums);
    }

    static List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        process(nums, 0);
        return result;
    }

    public static void process(int[] nums, int tem) {
        if (tem == nums.length - 1) {
            List<Integer> result1 = new ArrayList<>();
            for (int i : nums) {
                result1.add(i);
            }
            result.add(result1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = tem; i < nums.length; i++) {
            //进行剪枝
            //该位置没有相同数字才进来，有过相同数字就跳过
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                swap(nums, tem, i);
                process(nums, tem + 1);
                swap(nums, i, tem);
            }
        }
    }

    /**
     * 练习----不剪枝
     */
    static List<List<Integer>> list;
    static Set<List<Integer>> set;

    public List<List<Integer>> permuteUnique1(int[] nums) {
        set = new HashSet<>();
        list = new ArrayList<>();
        process1(nums, 0);
        return list;
    }

    public static void process1(int[] nums, int location) {
        if (location == nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int i : nums) {
                l.add(i);
            }
            if (!set.contains(l)) {
                list.add(l);
                set.add(l);
            }
        }
        for (int i = location; i < nums.length; i++) {
            swap(nums, i, location);
            process1(nums, location + 1);
            swap(nums, location, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
        Arrays.copyOf(nums,nums.length);
    }

}
