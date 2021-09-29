package com.Algorithm.Tree;

/**
 * 96. ��ͬ�Ķ���������
 * ����һ������ n ����ǡ�� n ���ڵ�����ҽڵ�ֵ�� 1 �� n ������ͬ�� ���������� �ж����֣�������������Ķ�����������������
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺n = 3
 * �����5
 * ʾ�� 2��
 *
 * ���룺n = 1
 * �����1
 */

import java.util.HashMap;

/**
 * ����˼·������n���ڵ���ڶ����������ĸ�����G(n)��1Ϊ���ڵ㣬2Ϊ���ڵ㣬...��nΪ���ڵ㣬��
 * 1Ϊ���ڵ�ʱ�����������ڵ����Ϊ0���������ڵ����Ϊn-1��
 * ͬ��2Ϊ���ڵ�ʱ�����������ڵ����Ϊ1���������ڵ�Ϊn-2��
 * ���Կɵ�G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
 */
public class N96_UniqueBST {
    public static void main(String[] args) {
        //1 2 3
        //1 2 5
    }
    public int numTrees(int n) {
        return help(n,new HashMap<Integer, Integer>());
    }
    public static int help(int n, HashMap<Integer, Integer> map){
        if(map.containsKey(n)){
            return map.get(n);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += help(i,map) * help(n-1 - i,map);
        }
        map.put(n,res);
        return res;
    }
}
