package com.Algorithm.UnionFind;

import com.mashibing.juc.c_022_RefTypeAndThreadLocal.M;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class N128_LongestSequence {
    public static void main(String[] args) {
        System.out.println(new N128_LongestSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2, 5, 6, 7}));
    }

    //并查集，i与i+1联合，最后求出并查集最大的集合的size
    public int longestConsecutive(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        UnionFind<Integer> uf = new UnionFind<>(list);
        for (int i : nums) {
            uf.union(i, i + 1);
        }
        int max = 0;
        for (UnionFind<Integer>.Node<Integer> node : uf.sizeMap.keySet()) {
            max = Math.max(max, uf.sizeMap.get(node));
        }
        return max;
    }

    //哈希表解决
    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int max = 0;
        for(int i : nums){
            int count = 0;
            if(!set.contains(i - 1)){
                while(set.contains(i)){
                    i++;
                    count++;
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
