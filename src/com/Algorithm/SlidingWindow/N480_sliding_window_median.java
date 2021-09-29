package com.Algorithm.SlidingWindow;

import java.util.*;

public class N480_sliding_window_median {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new WindowMediumHolder().medianSlidingWindow(new int[]{1, 2, 3, 4}, 4)));
    }

    public static class WindowMediumHolder {
        //��ߴ����
        PriorityQueue<Integer> small = new PriorityQueue<>(( o1,  o2) -> o2 - o1);//ϸ�ڣ�����ҲҪ��ֹ���,�����ü���
        //�ұ�С����
        PriorityQueue<Integer> large = new PriorityQueue<>();
        //��ʱɾ���Ĺ�ϣ��
        HashMap<Integer, Integer> delayed = new HashMap<>();
        //���ҵ�size
        int smallSize, largeSize;

        public void insert(int num) {
            //��һ�²����ı�
            if (small.isEmpty() || num <= small.peek()) {
                //�������
                smallSize++;
                small.add(num);
            } else {
                //�����ұ�
                largeSize++;
                large.add(num);
            }
            makeBalance();
        }

        public void erase(int num) {
            //�Ȳ�һ�����Ԫ��Ӧ�÷�����߻����ұ�
            if (num <= small.peek()) {
                //���
                smallSize--;
            } else {
                //�ұ�
                largeSize--;
            }
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);
            //ɾ�����Ҫ����ƽ�����
            makeBalance();
        }

        public double getMedium() {
            int n = smallSize + largeSize;
            if (n <= 0) return -1;//Խ����
            double result;
            if ((n & 1) == 0) {//ż��
                result = ((double) small.peek() + large.peek()) / 2;//Ҫ���мӷ����˷�������������,��һ�������ȼ�����һ������ʽ����
            } else {
                result = small.peek() * 1.0;
            }
            return result;
//            return (n & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
        }

        public void makeBalance() {
            if (smallSize + 1 == largeSize) {
                //�ұ����������
                smallSize++;
                largeSize--;
                small.add(large.poll());
            } else if (smallSize == largeSize + 2) {
                //�������ȥ�ұ�
                largeSize++;
                smallSize--;
                large.add(small.poll());
            }
            purge();//����һ�¿��Ƿ�Ѷ���ɾ����
        }

        public void purge() {
            //�����ߵ�
            int top;
            while (delayed.getOrDefault(small.peek(), 0) > 0) {
                //��ʱɾ��,�������޸���ʱ��
                top = small.poll();
                delayed.put(top, delayed.get(top) - 1);
            }
            while (delayed.getOrDefault(large.peek(), 0) > 0) {
                top = large.poll();//��ʱɾ��
                delayed.put(top, delayed.get(top) - 1);
            }
        }


        public double[] medianSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < k) return new double[]{};
            int N = nums.length;
            //�������ڷ�
            int L = 0, R = 0;
            ArrayList<Double> res = new ArrayList<>();
            WindowMediumHolder holder = new WindowMediumHolder();
            for (int i = 0; i < N; i++) {//£������N��Ԫ�ؽ���������
                if (R - L < k) {
                    holder.insert(nums[R++]);//����
                } else {
                    res.add(holder.getMedium());
                    //��ʼ����
                    holder.insert(nums[R++]);
                    holder.erase(nums[L++]);
                }
            }
            //�ռ����һ��
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
        //��ӳ�ʼֵ
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        //��ʼ�Ŀ��ţ�����дֱ�ӵ���
        Arrays.sort(window);
        res[0] = getMid(window);
        //���ڻ���
        for (int i = 0; i < nums.length - k; i++) {
            //��Ҫɾ������
            int index = search(window, nums[i]);
            //�滻Ϊ��Ҫ�������
            window[index] = nums[i + k];
            //���ð��
            while (index < window.length - 1 && window[index] > window[index + 1]) {
                swap(window, index, index + 1);
                index++;
            }
            //��ǰð��
            while (index > 0 && window[index] < window[index - 1]) {
                swap(window, index, index - 1);
                index--;
            }
            res[i + 1] = getMid(window);
        }
        return res;
    }

    //����
    private void swap(int[] window, int i, int j) {
        int temp = window[i];
        window[i] = window[j];
        window[j] = temp;
    }

    //���������λ��
    private double getMid(int[] window) {
        int len = window.length;
        if (window.length % 2 == 0) {
            //�������
            return window[len / 2] / 2.0 + window[len / 2 - 1] / 2.0;
        } else {
            return window[len / 2];
        }
    }

    //��򵥵Ķ��ֲ���
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

//    ���ߣ�ace7j
//    ���ӣ�https://leetcode-cn.com/problems/sliding-window-median/solution/480-java-er-fen-cha-zhao-mou-pao-pai-xu-8dcw4/
//    ��Դ�����ۣ�LeetCode��
//    ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
}
