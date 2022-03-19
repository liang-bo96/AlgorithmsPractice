package com.Algorithm.heap;

import java.sql.PreparedStatement;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 502. IPO
 * ���� ���ۣ�LeetCode��������ʼ IPO ��Ϊ���Ը��ߵļ۸񽫹�Ʊ��������Ͷ�ʹ�˾������ ϣ���� IPO ֮ǰ��չһЩ��Ŀ���������ʱ��� ������Դ���ޣ���ֻ���� IPO ֮ǰ������ k ����ͬ����Ŀ������ ���� ��������� k ����ͬ��Ŀ��õ�������ʱ��ķ�ʽ��
 * <p>
 * ���� n ����Ŀ������ÿ����Ŀ i ��������һ�������� profits[i] ������������Ŀ��Ҫ����С�ʱ� capital[i] ��
 * <p>
 * ���������ʱ�Ϊ w ���������һ����Ŀʱ���㽫��ô����������󽫱���ӵ�������ʱ��С�
 * <p>
 * �ܶ���֮���Ӹ�����Ŀ��ѡ�� ��� k ����ͬ��Ŀ���б��� ��������ʱ� ����������տɻ�õ�����ʱ���
 * <p>
 * �𰸱�֤�� 32 λ�з���������Χ�ڡ�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
 * �����4
 * ���ͣ�
 * ������ĳ�ʼ�ʱ�Ϊ 0��������Դ� 0 ����Ŀ��ʼ��
 * ����ɺ��㽫��� 1 ������������ʱ�����Ϊ 1��
 * ��ʱ�����ѡ��ʼ 1 �Ż� 2 ����Ŀ��
 * ������������ѡ��������Ŀ����������Ҫ��� 2 ����Ŀ�Ի�������ʱ���
 * ��ˣ���������󻯵��ʱ���Ϊ 0 + 1 + 3 = 4��
 * ʾ�� 2��
 * <p>
 * ���룺k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
 * �����6
 */
public class N502_IPO {
    public static void main(String[] args) {
        System.out.println(1|2);
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.capital - o2.capital;
            }
        });
        PriorityQueue<Node> queue1 = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.profit - o1.profit;
            }
        });

        for (int i = 0; i < profits.length; i++) {
            queue.add(new Node(profits[i], capital[i]));
        }

        for (int i = 0; i < k; i++) {
            while (queue.peek() != null && queue.peek().capital <= w) {
                queue1.add(queue.poll());
            }
            Node poll = queue1.poll();
            if (poll == null) {
                break;
            }
            w += poll.profit;
        }
        return w;
    }

    static class Node {
        public int profit;
        public int capital;

        public Node() {}

        public Node(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}

