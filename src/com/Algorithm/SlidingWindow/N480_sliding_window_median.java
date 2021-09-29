package com.Algorithm.SlidingWindow;

import java.util.*;

public class N480_sliding_window_median {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new WindowMediumHolder().medianSlidingWindow(new int[]{1, 2, 3, 4}, 4)));
    }

    public static class WindowMediumHolder {
        //左边大根堆
        PriorityQueue<Integer> small = new PriorityQueue<>(( o1,  o2) -> o2 - o1);//细节：这里也要防止溢出,不能用减法
        //右边小根堆
        PriorityQueue<Integer> large = new PriorityQueue<>();
        //延时删除的哈希表
        HashMap<Integer, Integer> delayed = new HashMap<>();
        //左右的size
        int smallSize, largeSize;

        public void insert(int num) {
            //看一下插入哪边
            if (small.isEmpty() || num <= small.peek()) {
                //插入左边
                smallSize++;
                small.add(num);
            } else {
                //插入右边
                largeSize++;
                large.add(num);
            }
            makeBalance();
        }

        public void erase(int num) {
            //先查一下这个元素应该放在左边还是右边
            if (num <= small.peek()) {
                //左边
                smallSize--;
            } else {
                //右边
                largeSize--;
            }
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);
            //删掉后就要进行平衡调整
            makeBalance();
        }

        public double getMedium() {
            int n = smallSize + largeSize;
            if (n <= 0) return -1;//越界了
            double result;
            if ((n & 1) == 0) {//偶数
                result = ((double) small.peek() + large.peek()) / 2;//要敏感加法，乘法可能溢出的情况,将一个提升等级，后一个会隐式升级
            } else {
                result = small.peek() * 1.0;
            }
            return result;
//            return (n & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
        }

        public void makeBalance() {
            if (smallSize + 1 == largeSize) {
                //右边来个来左边
                smallSize++;
                largeSize--;
                small.add(large.poll());
            } else if (smallSize == largeSize + 2) {
                //左边来个去右边
                largeSize++;
                smallSize--;
                large.add(small.poll());
            }
            purge();//清理一下看是否堆顶有删除的
        }

        public void purge() {
            //检查左边的
            int top;
            while (delayed.getOrDefault(small.peek(), 0) > 0) {
                //延时删除,别忘记修改延时表
                top = small.poll();
                delayed.put(top, delayed.get(top) - 1);
            }
            while (delayed.getOrDefault(large.peek(), 0) > 0) {
                top = large.poll();//延时删除
                delayed.put(top, delayed.get(top) - 1);
            }
        }


        public double[] medianSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < k) return new double[]{};
            int N = nums.length;
            //滑动窗口法
            int L = 0, R = 0;
            ArrayList<Double> res = new ArrayList<>();
            WindowMediumHolder holder = new WindowMediumHolder();
            for (int i = 0; i < N; i++) {//拢共就是N个元素进滑动窗口
                if (R - L < k) {
                    holder.insert(nums[R++]);//加入
                } else {
                    res.add(holder.getMedium());
                    //开始右移
                    holder.insert(nums[R++]);
                    holder.erase(nums[L++]);
                }
            }
            //收集最后一次
            res.add(holder.getMedium());
            double[] r = new double[res.size()];
            for (int i = 0; i < res.size(); i++) {
                r[i] = res.get(i);
            }
            return r;
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int[] window = new int[k];
        //添加初始值
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        //初始的快排，懒得写直接调用
        Arrays.sort(window);
        res[0] = getMid(window);
        //窗口滑动
        for (int i = 0; i < nums.length - k; i++) {
            //需要删除的数
            int index = search(window, nums[i]);
            //替换为需要插入的数
            window[index] = nums[i + k];
            //向后冒泡
            while (index < window.length - 1 && window[index] > window[index + 1]) {
                swap(window, index, index + 1);
                index++;
            }
            //向前冒泡
            while (index > 0 && window[index] < window[index - 1]) {
                swap(window, index, index - 1);
                index--;
            }
            res[i + 1] = getMid(window);
        }
        return res;
    }

    //交换
    private void swap(int[] window, int i, int j) {
        int temp = window[i];
        window[i] = window[j];
        window[j] = temp;
    }

    //求数组的中位数
    private double getMid(int[] window) {
        int len = window.length;
        if (window.length % 2 == 0) {
            //避免溢出
            return window[len / 2] / 2.0 + window[len / 2 - 1] / 2.0;
        } else {
            return window[len / 2];
        }
    }

    //最简单的二分查找
    private int search(int[] window, int target) {
        int left = 0;
        int right = window.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (window[mid] > target) {
                right = mid - 1;
            } else if (window[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

//    作者：ace7j
//    链接：https://leetcode-cn.com/problems/sliding-window-median/solution/480-java-er-fen-cha-zhao-mou-pao-pai-xu-8dcw4/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
