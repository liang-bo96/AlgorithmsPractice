package com.Algorithm.heap;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 *
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class N347_TopKElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        Queue<Node> queue = new PriorityQueue<>((o1,o2) -> o2.fre - o1.fre);
        for(int i : map.keySet()){
            queue.add(new Node(i,map.get(i)));
        }
        int[] result = new int[k];
        for(int i = 0; i < result.length; i++){
            result[i] = queue.poll().num;
        }
        return result;
    }
}
class Node{
    public int num;
    public int fre;

    public Node(int num, int fre) {
        this.num = num;
        this.fre = fre;
    }
}
