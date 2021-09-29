package com.Algorithm.LinkedList;

/**
 * 328. ��ż����
 * ����һ�������������е������ڵ��ż���ڵ�ֱ�����һ����ע�⣬����������ڵ��ż���ڵ�ָ���ǽڵ��ŵ���ż�ԣ������ǽڵ��ֵ����ż�ԡ�
 *
 * �볢��ʹ��ԭ���㷨��ɡ�����㷨�Ŀռ临�Ӷ�ӦΪ O(1)��ʱ�临�Ӷ�ӦΪ O(nodes)��nodes Ϊ�ڵ�������
 *
 * ʾ�� 1:
 *
 * ����: 1->2->3->4->5->NULL
 * ���: 1->3->5->2->4->NULL
 * ʾ�� 2:
 *
 * ����: 2->1->3->5->6->4->7->NULL
 * ���: 2->3->6->7->1->5->4->NULL
 */
public class N328_JiOuLianBiao {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(oddEvenList(a));
    }
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // head Ϊ������ͷ��㣬o Ϊ������β�ڵ�
        ListNode firstTail = head;
        // p Ϊż����ͷ���
        ListNode secondHead = head.next;
        // e Ϊż����β�ڵ�
        ListNode SecondTail = secondHead;
        while (firstTail.next != null && SecondTail.next != null) {
            firstTail.next = SecondTail.next;
            firstTail = firstTail.next;
            SecondTail.next = firstTail.next;
            SecondTail = SecondTail.next;
        }
        firstTail.next = secondHead;
        return head;
    }
}
