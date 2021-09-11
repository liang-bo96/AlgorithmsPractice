package com.Algorithm.Leetcode;

import edu.princeton.cs.algs4.In;

import java.util.*;

/**
 * 870. 优势洗牌
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 *
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [2,7,11,15], B = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 *
 * 输入：A = [12,24,8,32], B = [13,25,32,11]
 * 输出：[24,32,8,12]
 */
public class N870_RacingHorse {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new N870_RacingHorse().advantageCount(
                new int[]{2,0,4,1,2},
                new int[]{1,3,0,0,2}
        )));
    }
    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);

        // assigned[b] = list of a that are assigned to beat b
        Map<Integer, Deque<Integer>> assigned = new HashMap<>();
        for (int b: B) assigned.put(b, new LinkedList<>());

        // remaining = list of a that are not assigned to any b
        Deque<Integer> remaining = new LinkedList<>();

        // populate (assigned, remaining) appropriately
        // sortedB[j] is always the smallest unassigned element in B
        int j = 0;
        for (int a: sortedA) {
            if (a > sortedB[j]) {
                assigned.get(sortedB[j++]).add(a);
            } else {
                remaining.add(a);
            }
        }

        // Reconstruct the answer from annotations (assigned, remaining)
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; ++i) {
            // if there is some a assigned to b...
            if (assigned.get(B[i]).size() > 0)
                ans[i] = assigned.get(B[i]).pop();
            else
                ans[i] = remaining.pop();
        }
        return ans;
    }
    //for practice
    public int[] advantageCount1(int[] A, int[] B) {
        int[] result = new int[A.length];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i : B){
            map.put(i,new ArrayList<>());
        }
        int[] temb = B.clone();
        Arrays.sort(A);
        Arrays.sort(B);
        List<Integer> remain = new ArrayList<>();
        int j = 0;
        for(int i : A){
            if(i > B[j]){
                map.get(B[j++]).add(i);
            }else{
                remain.add(i);
            }
        }
        for(int i = 0; i < A.length; i++){
            if(map.get(temb[i]).size() > 0){
                result[i] = map.get(temb[i]).remove(map.get(temb[i]).size() - 1);
            }else{
                result[i] = remain.remove(0);
            }
        }
        return result;

    }
}
