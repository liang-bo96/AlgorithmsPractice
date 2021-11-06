package com.Algorithm.Leetcode;

import java.util.Arrays;

/**
 * 179. �����
 * ����һ��Ǹ����� nums����������ÿ������˳��ÿ�������ɲ�֣�ʹ֮���һ������������
 *
 * ע�⣺���������ܷǳ�����������Ҫ����һ���ַ���������������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [10,2]
 * �����"210"
 * ʾ�� 2��
 *
 * ���룺nums = [3,30,34,5,9]
 * �����"9534330"
 */
public class N179_LargestNumber {
    public static void main(String[] args) {
        System.out.println(new N179_LargestNumber().largestNumber(new int[]{2, 10, 3,30}));
    }

    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        String res = "";
        for (String s : arr) {
            res += s;
        }
        if (res.charAt(0) == '0') {
            res = "0";
        }
        return res;
    }
}
