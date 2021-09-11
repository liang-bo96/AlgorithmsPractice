package com.Algorithm.Leetcode;

import java.util.Arrays;

public class N4 {
    public static void main(String[] args) {
        System.out.println(new N4().findMedianSortedArrays1(new int[]{}, new int[]{1}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0;
        int total = nums1.length + nums2.length;
        int[] tem = new int[total];
        for (int i = 0; i < nums1.length; i++) {
            tem[i] = nums1[i];
        }
        for (int j = nums1.length; j < total; j++) {
            tem[j] = nums2[j - nums1.length];
        }
        Arrays.sort(tem);
        if (total % 2 == 0) {
            return ((double) tem[total / 2] + (double) tem[total / 2 - 1]) / 2;
        } else {
            return tem[total / 2];
        }
    }

    //for practice
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        boolean flag = false;
        if (total % 2 == 0) {
            flag = true;
        }
        if (flag) {
            if (len1 == 0) {
                return ((double) nums2[len2 / 2 - 1] + (double) nums2[len2 / 2]) / 2;
            } else if (len2 == 0) {
                return ((double) nums1[len1 / 2 - 1] + (double) nums1[len1 / 2]) / 2;
            }
            return help(total / 2 - 1, total / 2, nums1, nums2);
        } else {
            if (len1 == 0) {
                return (nums2[len2 / 2]);
            } else if (len2 == 0) {
                return ((double) nums1[len1 / 2]);
            }
            return help(total / 2, total / 2, nums1, nums2);
        }
    }

    public static double help(int left, int right, int[] n1, int[] n2) {
        int[] ref = new int[n1.length + n2.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < n1.length + n2.length; i++) {
            if (index1 < n1.length && index2 < n2.length && n1[index1] < n2[index2]) {
                ref[i] = n1[index1++];
            } else if (index1 < n1.length && index2 < n2.length && n1[index1] >= n2[index2]) {
                ref[i] = n2[index2++];
            }
            if (index1 == n1.length || index2 == n2.length) {
                fill(index1, index2, i, ref, n1, n2);
                break;
            }
        }
        return ((double) ref[left] + (double) ref[right]) / 2;
    }

    public static void fill(int index1, int index2, int location, int[] ref, int[] n1, int[] n2) {
        if (index1 == n1.length) {
            for (int i = location + 1; i < n1.length + n2.length; i++) {
                ref[i] = n2[index2++];
            }
        } else {
            for (int i = location + 1; i < n1.length + n2.length; i++) {
                ref[i] = n1[index1++];
            }
        }
    }
}
