package com.Algorithm.SlidingWindow;

import java.util.*;

public class N480_sliding_window_median {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new WindowMediumHolder().medianSlidingWindow(new int[]{1, 2, 3, 4}, 4)));
    }

    public static class WindowMediumHolder {
        //左边大根堆
        PriorityQueue<Integer> small = new PriorityQueue<>((o1, o2) -> o2 > o1 ? 1 : -1);//细节：这里也要防止溢出,不能用减法
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
}
