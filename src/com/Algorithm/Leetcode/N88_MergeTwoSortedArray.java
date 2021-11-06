package com.Algorithm.Leetcode;

import static com.Algorithm.Leetcode.N46.swap;

/**
 * 88. �ϲ�������������
 * ���������� �ǵݼ�˳�� ���е��������� nums1 �� nums2�������������� m �� n ���ֱ��ʾ nums1 �� nums2 �е�Ԫ����Ŀ��
 * <p>
 * ���� �ϲ� nums2 �� nums1 �У�ʹ�ϲ��������ͬ���� �ǵݼ�˳�� ���С�
 * <p>
 * ע�⣺���գ��ϲ������鲻Ӧ�ɺ������أ����Ǵ洢������ nums1 �С�Ϊ��Ӧ�����������nums1 �ĳ�ʼ����Ϊ m + n������ǰ m ��Ԫ�ر�ʾӦ�ϲ���Ԫ�أ��� n ��Ԫ��Ϊ 0 ��Ӧ���ԡ�nums2 �ĳ���Ϊ n ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * �����[1,2,2,3,5,6]
 * ���ͣ���Ҫ�ϲ� [1,2,3] �� [2,5,6] ��
 * �ϲ������ [1,2,2,3,5,6] ������б��Ӵֱ�ע��Ϊ nums1 �е�Ԫ�ء�
 * ʾ�� 2��
 * <p>
 * ���룺nums1 = [1], m = 1, nums2 = [], n = 0
 * �����[1]
 * ���ͣ���Ҫ�ϲ� [1] �� [] ��
 * �ϲ������ [1] ��
 * ʾ�� 3��
 * <p>
 * ���룺nums1 = [0], m = 0, nums2 = [1], n = 1
 * �����[1]
 * ���ͣ���Ҫ�ϲ��������� [] �� [1] ��
 * �ϲ������ [1] ��
 * ע�⣬��Ϊ m = 0 ������ nums1 ��û��Ԫ�ء�nums1 �н���� 0 ������Ϊ��ȷ���ϲ��������˳����ŵ� nums1 �С�
 */
public class N88_MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] a = new int[]{2,0};
        int[] b = new int[]{1};
        merge1(a, 1, b, 1);
    }
//--------------------------reference--------------------------
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }


    //practice
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0 || m == n){
            nums1 = nums2;
            return;
        }
        if(n == 0){
            return;
        }
        for (int i = m-1; i >= 0; i--) {
            swap(nums1,i,i+n);
        }
        int location1 = n;
        int location2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            if(location1 == nums1.length){
                nums1[i] = nums2[location2++];
            }else if(location2 == n){
                nums1[i] = nums1[location1++];
            }else if(nums1[location1] < nums2[location2]){
                nums1[i] = nums1[location1++];
            }else{
                nums1[i] = nums2[location2++];
            }
        }
    }


}