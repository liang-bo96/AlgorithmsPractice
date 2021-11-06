package com.Algorithm.BinarySearch;

/**
 * 162. Ѱ�ҷ�ֵ
 * ��ֵԪ����ָ��ֵ�ϸ������������ֵ��Ԫ�ء�
 *
 * ����һ���������� nums���ҵ���ֵԪ�ز�������������������ܰ��������ֵ������������£����� �κ�һ����ֵ ����λ�ü��ɡ�
 *
 * ����Լ��� nums[-1] = nums[n] = -�� ��
 *
 * �����ʵ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨����������⡣
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,2,3,1]
 * �����2
 * ���ͣ�3 �Ƿ�ֵԪ�أ���ĺ���Ӧ�÷��������� 2��
 * ʾ�� 2��
 *
 * ���룺nums = [1,2,1,3,5,6,4]
 * �����1 �� 5
 * ���ͣ���ĺ������Է������� 1�����ֵԪ��Ϊ 2��
 *      ���߷������� 5�� ���ֵԪ��Ϊ 6��
 */
public class N162_FindPeekEle {
    public static void main(String[] args) {
        System.out.println(new N162_FindPeekEle().findPeakElement1(new int[]{1}));
    }
    //�������඼�Ǹ����ҪѰ�ҷ�ֵ��ÿ��ѡȡ����������ֵ����ߴ��˵����߱���ɽ�壨������-���󣩸�-���ң��ͣ���
    // �ұߴ�˵���ұ߱���ɽ�壨���󣩵�-���ң���-�����
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public int findPeakElement1(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
