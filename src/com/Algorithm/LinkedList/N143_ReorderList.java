package com.Algorithm.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 *  L0 → L1 → … → Ln-1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: head = [1,2,3,4]
 * 输出: [1,4,2,3]
 * 示例 2:
 *
 *
 *
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,5,2,4,3]
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
    //1 先找中点
    //2 右半部分链表反转
    //3 左右链表合并
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
    //偶数个数链表找的是左边的中点
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
