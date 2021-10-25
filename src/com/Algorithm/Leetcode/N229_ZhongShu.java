package com.Algorithm.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 229. 求众数 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ? n/3 ? 次的元素。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 */
public class N229_ZhongShu {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i) > nums.length / 3) {
                res.add(i);
            }
        }
        return res;
    }

    //进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
    public List<Integer> majorityElement1(int[] nums) {
        int e1 = 0;
        int e2 = 0;
        int count1 = 0;
        int count2 = 0;
        //同时对两个元素投票
        for (int i : nums) {
            if (count1 > 0 && i == e1) {
                count1++;
            } else if (count2 > 0 && i == e2) {
                count2++;
            } else if (count1 == 0) {
                e1 = i;
                count1++;
            } else if (count2 == 0) {
                e2 = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        if(e1 == e2){
            return new ArrayList<>(Arrays.asList(e1));
        }
        //统计次数
        int c1 = 0;
        int c2 = 0;
        for (int i : nums) {
            if (i == e1) {
                c1++;
            }
            if (i == e2) {
                c2++;
            }
        }
        List<Integer> list = new ArrayList<>();
        //次数够了的加到结果里
        if(c1 > nums.length / 3){
            list.add(e1);
        }
        if(c2 > nums.length / 3){
            list.add(e2);
        }
        return list;
    }
}
