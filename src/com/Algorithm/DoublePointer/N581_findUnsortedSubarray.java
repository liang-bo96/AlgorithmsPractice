package com.Algorithm.DoublePointer;

import edu.princeton.cs.algs4.In;

/**
 * 581. �����������������
 * ����һ���������� nums ������Ҫ�ҳ�һ�� ���������� �����������������������������ô�������鶼���Ϊ��������
 * <p>
 * �����ҳ���������� ��� �����飬��������ĳ��ȡ�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [2,6,4,8,10,9,15]
 * �����5
 * ���ͣ���ֻ��Ҫ�� [6, 4, 8, 10, 9] ��������������ô���������Ϊ��������
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,2,3,4]
 * �����0
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1]
 * �����0
 */
public class N581_findUnsortedSubarray {
    public static void main(String[] args) {
        System.out.println(new N581_findUnsortedSubarray().findUnsortedSubarray(new int[]{1,3,2,3,3}));
    }
    //references
    public int findUnsortedSubarray1(int[] arr) {
        if(arr == null || arr.length < 2){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int R = 0;
        int L = 0;
        //�ҵ����Ҳ�С��max�Ľڵ㣬�ýڵ��Ҳ���������������
        for (int i = 0; i < arr.length; i++) {
            if(max > arr[i]) {
                R = i;
            }
            max = Math.max(max, arr[i]);
        }
        //�ҵ���������min�Ľڵ㣬�ýڵ�����ǵݼ�����
        for (int i = arr.length - 1; i >= 0; i--) {
            if(min < arr[i]) {
                L = i;
            }
            min = Math.min(min, arr[i]);
        }
        return R == L ? 0 : R - L + 1;
    }
    //�������� ��ʱ
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (judge(nums, 0, nums.length - 1, j, i)) {
                    min = Math.min(min, i - j + 1);
                }
            }
        }
        return min == 1 ? 0 :min;
    }

    public static boolean judge(int[] arr, int start, int end, int left, int right) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        if (left == start && right == end) {
            return true;
        } else if (left == start) {
            return max <= arr[right + 1] && Sorted(arr, right + 1, end);
        } else if (right == end) {
            return min >= arr[left - 1] && Sorted(arr, start, left - 1);
        } else {
            return Sorted(arr, start, left - 1) &&
                    Sorted(arr, right + 1, end) &&
                    max <= arr[right + 1] && min >= arr[left - 1];
        }
    }

    public static boolean Sorted(int[] arr, int left, int right) {
        if(right <= left){
            return true;
        }
        for (int i = left + 1; i <= right; i++) {
            if(arr[i] < arr[i - 1]){
                return false;
            }
        }
        return true;
    }
}
