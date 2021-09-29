package com.Algorithm.LinkedList;

import java.util.List;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class N19_RemoveNthNode {
    //两趟扫描
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
    //一趟扫描
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
