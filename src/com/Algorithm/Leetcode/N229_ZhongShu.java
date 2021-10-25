package com.Algorithm.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 229. ������ II
 * ����һ����СΪ n ���������飬�ҳ��������г��ֳ��� ? n/3 ? �ε�Ԫ�ء�
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺[3,2,3]
 * �����[3]
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1]
 * �����[1]
 * ʾ�� 3��
 * <p>
 * ���룺[1,1,1,3,3,2,2,2]
 * �����[1,2]
 */
public class N229_ZhongShu {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i) > nums.length / 3) {
                res.add(i);
            }
        }
        return res;
    }

    //���ף��������ʱ�临�Ӷ�Ϊ O(n)���ռ临�Ӷ�Ϊ O(1)���㷨��������⡣
    public List<Integer> majorityElement1(int[] nums) {
        int e1 = 0;
        int e2 = 0;
        int count1 = 0;
        int count2 = 0;
        //ͬʱ������Ԫ��ͶƱ
        for (int i : nums) {
            if (count1 > 0 && i == e1) {
                count1++;
            } else if (count2 > 0 && i == e2) {
                count2++;
            } else if (count1 == 0) {
                e1 = i;
                count1++;
            } else if (count2 == 0) {
                e2 = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        if(e1 == e2){
            return new ArrayList<>(Arrays.asList(e1));
        }
        //ͳ�ƴ���
        int c1 = 0;
        int c2 = 0;
        for (int i : nums) {
            if (i == e1) {
                c1++;
            }
            if (i == e2) {
                c2++;
            }
        }
        List<Integer> list = new ArrayList<>();
        //�������˵ļӵ������
        if(c1 > nums.length / 3){
            list.add(e1);
        }
        if(c2 > nums.length / 3){
            list.add(e2);
        }
        return list;
    }
}
