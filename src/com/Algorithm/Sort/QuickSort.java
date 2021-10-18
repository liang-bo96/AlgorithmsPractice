package com.Algorithm.Sort;

import java.util.Arrays;

public class QuickSort {

    public static void QuickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if (left >= right) {
            return;
        }
        //设置最左边的元素为基准值
        int key = num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = left;
        int j = right;
        while (i < j) {
            //j向左移，直到遇到比key小的值
            while (num[j] >= key && i < j) {
                j--;
            }
            //i向右移，直到遇到比key大的值
            while (num[i] <= key && i < j) {
                i++;
            }
            //i和j指向的元素交换
            if (i < j) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
        num[left] = num[i];
        num[i] = key;

        QuickSort(num, left, i - 1);
        QuickSort(num, i + 1, right);
    }

    public static void sort1(int[] num, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = partition(num, start, end);
        sort1(num, start, i - 1);
        sort1(num, i + 1, end);
    }

    public static int partition(int[] n, int start, int end) {
        int tem = n[start];
        int location = start;
        while (start < end) {
            while (n[start + 1] < tem) {
                start++;
            }
            while (n[end] > tem) {
                end--;
            }
            exchange(n, start, end);
        }
        exchange(n, location, start);
        return start;
    }

    public static void exchange(int[] n, int start, int end) {
        int tem = n[start];
        n[start] = n[end];
        n[end] = tem;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 7, 6, 5, 4, 6};
        QuickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}