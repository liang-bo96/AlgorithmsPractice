package com.Algorithm.BinarySearch;

/**
 * 4. Ѱ�����������������λ��
 * ����������С�ֱ�Ϊ m �� n �����򣨴�С�������� nums1 �� nums2�������ҳ���������������������� ��λ�� ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums1 = [1,3], nums2 = [2]
 * �����2.00000
 * ���ͣ��ϲ����� = [1,2,3] ����λ�� 2
 * ʾ�� 2��
 *
 * ���룺nums1 = [1,2], nums2 = [3,4]
 * �����2.50000
 * ���ͣ��ϲ����� = [1,2,3,4] ����λ�� (2 + 3) / 2 = 2.5
 * ʾ�� 3��
 *
 * ���룺nums1 = [0,0], nums2 = [0,0]
 * �����0.00000
 * ʾ�� 4��
 *
 * ���룺nums1 = [], nums2 = [1]
 * �����1.00000
 * ʾ�� 5��
 *
 * ���룺nums1 = [2], nums2 = []
 * �����2.00000
 */
public class N4_MedianOfSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //��ż��������������ϲ����������������������ͬ���� k ��
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) +
                getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //�� len1 �ĳ���С�� len2���������ܱ�֤�����������ˣ�һ���� len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

//    ���ߣ�windliang
//    ���ӣ�https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
//    ��Դ�����ۣ�LeetCode��
//    ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
}
