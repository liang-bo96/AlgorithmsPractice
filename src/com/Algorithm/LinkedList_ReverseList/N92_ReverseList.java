package com.Algorithm.LinkedList_ReverseList;

import com.Algorithm.LinkedList.ListNode;

import java.util.List;

/**
 * 92. ��ת���� II
 * ���㵥�����ͷָ�� head ���������� left �� right ������ left <= right �����㷴ת��λ�� left ��λ�� right ������ڵ㣬���� ��ת������� ��
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺head = [1,2,3,4,5], left = 2, right = 4
 * �����[1,4,3,2,5]
 * ʾ�� 2��
 *
 * ���룺head = [5], left = 1, right = 1
 * �����[5]
 */
public class N92_ReverseList {
    /**
     * Java 1ms��ʱ��ռ��90+�� ʵ��˼· ����1->2->3->4->5, left = 2, right=4 Ϊ��:
     *
     * ��λ��Ҫ��ת���ֵ�ͷ�ڵ� 2��head = 2��ǰ����� 1��pre = 1��
     * ��ǰ�ڵ����һ���ڵ�3����Ϊǰ���ڵ����һ���ڵ� 1->3->2->4->5,
     * ��ǰ�����Ϊ2�� ǰ�������Ȼ��1���ظ���һ������������
     * 1->4->3->2->5.
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i = left; i < right; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }
}
