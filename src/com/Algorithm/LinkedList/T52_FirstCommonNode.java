package com.Algorithm.LinkedList;

/**
 * �������������ҳ����ǵĵ�һ�������ڵ㡣
 *
 * ���������������
 *
 *
 *
 * �ڽڵ� c1 ��ʼ�ཻ��
 *
 * ?
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * �����Reference of the node with value = 8
 * ������ͣ��ཻ�ڵ��ֵΪ 8 ��ע�⣬��������б��ཻ����Ϊ 0�����Ӹ��Եı�ͷ��ʼ�������� A Ϊ [4,1,8,4,5]������ B Ϊ [5,0,1,8,4,5]���� A �У��ཻ�ڵ�ǰ�� 2 ���ڵ㣻�� B �У��ཻ�ڵ�ǰ�� 3 ���ڵ㡣
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class T52_FirstCommonNode {
    //��������Ѱ�ҵ�һ�������ڵ� û�з��ؿ�
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode n1 = headA;
        ListNode n2 = headB;
        //��һ��һֱ����ң�Ϊ��������һ������ͷ������
        //����й����ڵ�ͻ���ȣ����û�����Ϊ������ѭ��
        while(n1 != n2){
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }
}
