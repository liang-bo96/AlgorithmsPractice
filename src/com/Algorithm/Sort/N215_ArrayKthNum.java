package com.Algorithm.Sort;

import java.util.Arrays;

import static com.Algorithm.Leetcode.N46.swap;

/**
 * 215. �����еĵ�K�����Ԫ��
 * ������������ nums ������ k���뷵�������е� k ������Ԫ�ء�
 * <p>
 * ��ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [3,2,1,5,6,4] �� k = 2
 * ���: 5
 * ʾ�� 2:
 * <p>
 * ����: [3,2,3,1,2,4,5,5,6] �� k = 4
 * ���: 4
 * <p>
 * <p>
 * ��ʾ��
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
            //��ָ���ȶ�
            while (arr[j] >= tem && i < j) {
                j--;
            }
            //��ָ���
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


    //-------------------------------������ϰ-------------------------------
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
            //��ָ���ȶ�
            while (arr[j] >= tem && i < j) {
                j--;
            }
            //��ָ���
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
