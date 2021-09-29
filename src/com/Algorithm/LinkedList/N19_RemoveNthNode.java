package com.Algorithm.LinkedList;

import java.util.List;

/**
 * 19. ɾ������ĵ����� N �����
 * ����һ������ɾ������ĵ����� n ����㣬���ҷ��������ͷ��㡣
 *
 * ���ף����ܳ���ʹ��һ��ɨ��ʵ����
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺head = [1,2,3,4,5], n = 2
 * �����[1,2,3,5]
 * ʾ�� 2��
 *
 * ���룺head = [1], n = 1
 * �����[]
 * ʾ�� 3��
 *
 * ���룺head = [1,2], n = 1
 * �����[1]
 */
public class N19_RemoveNthNode {
    //����ɨ��
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tem = new ListNode(-1);
        tem.next = head;
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        head = tem;
        for (int i = 0; i < len - n ; i++) {
            head = head.next;
        }
        head.next = head.next.next;
        return tem.next;
    }
    //һ��ɨ��
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode tem = new ListNode(-1);
        tem.next = head;
        ListNode fast = tem;
        ListNode slow = tem;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return tem.next;
    }
}
