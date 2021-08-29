package com.Algorithm.SlidingWindow;

import java.util.*;

public class N480_sliding_window_median {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new N480_sliding_window_median().medianSlidingWindow(new int[]{1, 2, 3, 4}, 4)));
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null || k > nums.length) return null;
        List<Long> list = new LinkedList<>();
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            list.add((long)nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            Collections.sort(list);
            result[i - k] = k % 2 == 0 ? (list.get(k/2) + list.get(k / 2))*0.5:list.get(k /2);
            for(int j = 0; j < list.size(); j++){
                if(list.get(j) == nums[i - k]){
                    list.remove(j);
                }
            }
            list.add((long)nums[i]);
        }
        Collections.sort(list);
        result[nums.length - k ] =k % 2 == 0 ?  (list.get(k/2) + list.get(k / 2 - 1))*0.5:list.get(k /2);
        return result;
    }
}
