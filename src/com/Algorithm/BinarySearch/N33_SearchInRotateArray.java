package com.Algorithm.BinarySearch;

/**
 * 33. ������ת��������
 * �������� nums ���������У������е�ֵ ������ͬ ��
 *
 * �ڴ��ݸ�����֮ǰ��nums ��Ԥ��δ֪��ĳ���±� k��0 <= k < nums.length���Ͻ����� ��ת��ʹ�����Ϊ [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]���±� �� 0 ��ʼ �����������磬 [0,1,2,4,5,6,7] ���±� 3 ������ת����ܱ�Ϊ [4,5,6,7,0,1,2] ��
 *
 * ���� ��ת�� ������ nums ��һ������ target ����� nums �д������Ŀ��ֵ target ���򷵻������±꣬���򷵻� -1 ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [4,5,6,7,0,1,2], target = 0
 * �����4
 * ʾ�� 2��
 *
 * ���룺nums = [4,5,6,7,0,1,2], target = 3
 * �����-1
 * ʾ�� 3��
 *
 * ���룺nums = [1], target = 0
 * �����-1
 */
public class N33_SearchInRotateArray {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //�������
            else if(nums[left] < nums[mid]){
                //�����������
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            //�ұ�����
            else {
                //���ұ�������
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
