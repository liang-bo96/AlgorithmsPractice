package com.Algorithm.SlidingWindow;
/*
239. 滑动窗口最大值
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。
示例 1：

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
示例 2：

输入：nums = [1], k = 1
输出：[1]
示例 3：

输入：nums = [1,-1], k = 1
输出：[1,-1]
示例 4：

输入：nums = [9,11], k = 2
输出：[11]
示例 5：

输入：nums = [4,-2], k = 2
输出：[4]


提示：

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
*/

import java.io.PrintWriter;
import java.util.*;

public class N239_FindMaxInArray {
    public static void main(String[] args) {
        N239_FindMaxInArray n239 = new N239_FindMaxInArray();
        System.out.println(Arrays.toString(n239.maxSlidingWindowPriorityQueue(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(n239.maxSlidingWindowSingleQueue(new int[]{1, -1}, 1)));
    }

    //优先队列实现
    public int[] maxSlidingWindowPriorityQueue(int[] nums, int k) {
        if(k > nums.length) return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i = 0 ; i < k ; i++){
            queue.add(nums[i]);
        }
        int[] result = new int[nums.length - k + 1];
        for(int i = 0 ; i < nums.length-k ; i++){
            result[i] = queue.peek();
            queue.add(nums[k+i]);
            queue.remove(nums[i]);
        }
        result[nums.length - k] = queue.poll();
        return result;
    }

    //单调队列实现
    public int[] maxSlidingWindowSingleQueue(int[] nums, int k) {
        if(k > nums.length) return new int[0];

        SingleQueue queue = new SingleQueue();
        int[] result = new int[nums.length - k + 1];

        for(int i = 0 ; i < nums.length;i++){
            if(i < k){
                queue.add(nums[i]);
            }else{
                result[i-k] = queue.max();
                queue.add(nums[i]);
                queue.delete(nums[i-k]);
            }
        }
        result[nums.length - k] = queue.max();

        return result;
    }


}
class SingleQueue{
    public Deque<Integer> queue = new ArrayDeque<>();

    public void  add(int n){
        while(!queue.isEmpty() && n > queue.getLast()){
            queue.removeLast();
        }
        queue.addLast(n);
    }
    public void  delete(int n){
        if(!queue.isEmpty() && queue.getFirst() == n){
            queue.removeFirst();
        }
    }
    public int max(){
        return queue.getFirst();
    }
}
