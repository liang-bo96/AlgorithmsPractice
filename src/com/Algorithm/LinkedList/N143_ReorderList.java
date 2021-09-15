package com.Algorithm.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. ��������
 * ����һ�������� L ��ͷ�ڵ� head �������� L ��ʾΪ��
 *
 *  L0 �� L1 �� �� �� Ln-1 �� Ln
 * �뽫���������к��Ϊ��
 *
 * L0 �� Ln �� L1 �� Ln-1 �� L2 �� Ln-2 �� ��
 *
 * ����ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 *
 *
 *
 * ʾ�� 1:
 *
 *
 *
 * ����: head = [1,2,3,4]
 * ���: [1,4,2,3]
 * ʾ�� 2:
 *
 *
 *
 * ����: head = [1,2,3,4,5]
 * ���: [1,5,2,4,3]
 */
public class N143_ReorderList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        new N143_ReorderList().reorderList(a);
    }

    public void reorderList(ListNode head) {
        List<Integer> l = new ArrayList<>();
        ListNode phead = head;
        while (head != null) {
            l.add(head.val);
            head = head.next;
        }
        int left = 1;
        int right = l.size() - 1;
        for (int i = 1; i < l.size(); i++) {
            if (left == right) {
                phead.next.val = l.get(right);
                break;
            }
            if (left > right) {
                break;
            }
            phead.next.val = l.get(right--);
            phead = phead.next;
            phead.next.val = l.get(left++);
            phead = phead.next;
        }
    }
    //--------------------reference---------------------------
    //1 �����е�
    //2 �Ұ벿������ת
    //3 ��������ϲ�
    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }
    //ż�����������ҵ�����ߵ��е�
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
