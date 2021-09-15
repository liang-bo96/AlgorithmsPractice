package com.Algorithm.Sort;

import java.util.Arrays;

import static com.Algorithm.Leetcode.N46.swap;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 */
public class N215_ArrayKthNum {
    public static void main(String[] args) {
        System.out.println(new N215_ArrayKthNum().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 9));
    }

    public int findKthLargest(int[] nums, int k) {
        return sort(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int sort(int[] arr, int left, int right, int k) {
        int location = partition(arr, left, right);
        if (location == k) {
            return arr[location];
        } else if (location > k) {
            return sort(arr, left, location - 1, k);
        } else {
            return sort(arr, location + 1, right, k);
        }
    }


    public static int partition(int[] arr, int left, int right) {
        int tem = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            //右指针先动
            while (arr[j] >= tem && i < j) {
                j--;
            }
            //左指针后动
            while (arr[i] <= tem && i < j) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        arr[left] = arr[i];
        arr[i] = tem;
        return left;
    }


    //-------------------------------快排练习-------------------------------
    public static void quickSort(int[] arr) {
        quickSorthelper(arr, 0, arr.length - 1);
    }

    public static void quickSorthelper(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int tem = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            //右指针先动
            while (arr[j] >= tem && i < j) {
                j--;
            }
            //左指针后动
            while (arr[i] <= tem && i < j) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        arr[left] = arr[i];
        arr[i] = tem;
        quickSorthelper(arr, left, i - 1);
        quickSorthelper(arr, i + 1, right);
    }

}
