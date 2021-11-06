package com.Algorithm.heap;

import java.util.*;

/**
 * 347. ǰ K ����ƵԪ��
 * ����һ���������� nums ��һ������ k �����㷵�����г���Ƶ��ǰ k �ߵ�Ԫ�ء�����԰� ����˳�� ���ش𰸡�
 *
 *
 *
 * ʾ�� 1:
 *
 * ����: nums = [1,1,1,2,2,3], k = 2
 * ���: [1,2]
 * ʾ�� 2:
 *
 * ����: nums = [1], k = 1
 * ���: [1]
 *
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 105
 * k ��ȡֵ��Χ�� [1, �����в���ͬ��Ԫ�صĸ���]
 * ��Ŀ���ݱ�֤��Ψһ�����仰˵��������ǰ k ����ƵԪ�صļ�����Ψһ��
 *
 *
 * ���ף���������㷨��ʱ�临�Ӷ� ���� ���� O(n log n) ������ n �������С��
 */
public class N347_TopKElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        Queue<Node> queue = new PriorityQueue<>((o1,o2) -> o2.fre - o1.fre);
        for(int i : map.keySet()){
            queue.add(new Node(i,map.get(i)));
        }
        int[] result = new int[k];
        for(int i = 0; i < result.length; i++){
            result[i] = queue.poll().num;
        }
        return result;
    }
}
class Node{
    public int num;
    public int fre;

    public Node(int num, int fre) {
        this.num = num;
        this.fre = fre;
    }
}
