package com.Algorithm.Array;

import java.util.Arrays;

/**
 * 135. �ַ��ǹ�
 * ��ʦ��������Ƿַ��ǹ����� N ������վ����һ��ֱ�ߣ���ʦ�����ÿ�����ӵı��֣�Ԥ�ȸ��������֡�
 * <p>
 * ����Ҫ��������Ҫ�󣬰�����ʦ����Щ���ӷַ��ǹ���
 * <p>
 * ÿ���������ٷ��䵽 1 ���ǹ���
 * ���ָ��ߵĺ��ӱ�������������λ���ӻ�ø�����ǹ���
 * ��ô������������ʦ������Ҫ׼�����ٿ��ǹ��أ�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺[1,0,2]
 * �����5
 * ���ͣ�����Էֱ�����������ӷַ� 2��1��2 ���ǹ���
 * ʾ�� 2��
 * <p>
 * ���룺[1,2,2]
 * �����4
 * ���ͣ�����Էֱ�����������ӷַ� 1��2��1 ���ǹ���
 * ����������ֻ�õ� 1 ���ǹ�������������������������
 */
public class N135_Candy {
    public static void main(String[] args) {
        System.out.println(candy2(new int[]{1, 2, 3, 3, 3, 2, 1}));
    }

    public static int candy(int[] ratings) {
        int count = 0;
        int[] re = new int[ratings.length];
        Arrays.fill(re, 1);
        //���ұ����������������ķ������ͽ��ǹ�������һ
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                re[i] = re[i - 1] + 1;
            }
        }
        //�ҵ�������������������ķ������ͽ��ǹ�������һ
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                re[i] = Math.max(re[i + 1] + 1, re[i]);
            }
        }
        for (int i : re) {
            count += i;
        }
        return count;
    }

    public static int candy2(int[] ratings) {
        int[] arr = new int[ratings.length];
        Arrays.fill(arr, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1] && arr[i] <= arr[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && arr[i] <= arr[i + 1]) {
                arr[i] = arr[i + 1] + 1;
            }
        }
        int count = 0;
        for (int i : arr) {
            count += i;
        }
        return count;
    }
}
