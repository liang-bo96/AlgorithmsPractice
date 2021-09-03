package com.Algorithm.UnionFind;

import com.mashibing.juc.c_022_RefTypeAndThreadLocal.M;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 128. ���������
 * ����һ��δ������������� nums ���ҳ���������������У���Ҫ������Ԫ����ԭ�������������ĳ��ȡ�
 * <p>
 * ������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ O(n) ���㷨��������⡣
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [100,4,200,1,3,2]
 * �����4
 * ���ͣ���������������� [1, 2, 3, 4]�����ĳ���Ϊ 4��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [0,3,7,2,5,8,4,6,0,1]
 * �����9
 */
public class N128_LongestSequence {
    public static void main(String[] args) {
        System.out.println(new N128_LongestSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2, 5, 6, 7}));
    }

    //���鼯��i��i+1���ϣ����������鼯���ļ��ϵ�size
    public int longestConsecutive(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        UnionFind<Integer> uf = new UnionFind<>(list);
        for (int i : nums) {
            uf.union(i, i + 1);
        }
        int max = 0;
        for (UnionFind<Integer>.Node<Integer> node : uf.sizeMap.keySet()) {
            max = Math.max(max, uf.sizeMap.get(node));
        }
        return max;
    }

    //��ϣ����
    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int max = 0;
        for(int i : nums){
            int count = 0;
            if(!set.contains(i - 1)){
                while(set.contains(i)){
                    i++;
                    count++;
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
