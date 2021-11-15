package com.Algorithm.Sort;
//����Ը���ͳ��
public class T51_Nixudui {
    int count;
    public int reversePairs(int[] nums) {
        count = 0;
        merge(nums, 0, nums.length - 1);
        return count;
    }

    public void merge(int[] nums, int left, int right) {
        int mid = left + ((right - left) >> 1);
        if (left < right) {
            merge(nums, left, mid);
            merge(nums, mid + 1, right);
            mergeSort(nums, left, mid, right);
        }
    }

    public void mergeSort(int[] nums, int left, int mid, int right) {
        int[] temparr = new int[right - left + 1];
        int index = 0;
        int temp1 = left, temp2 = mid + 1;

        while (temp1 <= mid && temp2 <= right) {
            if (nums[temp1] <= nums[temp2]) {
                temparr[index++] = nums[temp1++];
            } else {
                //����ͳ������Եĸ���
                count += (mid - temp1 + 1);
                temparr[index++] = nums[temp2++];
            }
        }
        //�����ʣ�������������
        while (temp1 <= mid) {
            temparr[index++] = nums[temp1++];
        }
        //���ұ�ʣ�������������
        while (temp2 <= right) {
            temparr[index++] = nums[temp2++];
        }
        //���������е�������nums����
        for (int k = 0; k < temparr.length; k++) {
            nums[k + left] = temparr[k];
        }
    }
}
