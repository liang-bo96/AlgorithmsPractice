package com.Algorithm.LinkedList;

import java.util.HashMap;

/*
* 2. 两数相加
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。



示例 1：


输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：

输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：

输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]*/
public class N2_ListNodeAdd {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(9);
        ListNode d = new ListNode(9);
        ListNode e = new ListNode(9);
        ListNode f = new ListNode(9);
        ListNode g = new ListNode(9);
        ListNode h = new ListNode(9);
        ListNode i = new ListNode(9);
        ListNode j = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;
        System.out.println(Double.MAX_VALUE / Integer.MAX_VALUE);
        System.out.println(addTwoNumbers3(a, j));
    }

    //非递归版本
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tem = new ListNode(-1);
        ListNode head = tem;
        ListNode ll1 = l1;
        ListNode ll2 = l2;
        int k = 0;
        int len1 = 0;
        int len2 = 0;

        while (ll1 != null) {
            len1++;
            ll1 = ll1.next;
        }
        while (ll2 != null) {
            len2++;
            ll2 = ll2.next;
        }
        int total = Math.max(len1, len2);
        for (int i = 0; i < total; i++) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int t = v1 + v2 + k;
            if (v1 + v2 + k >= 10) {
                t = (v1 + v2 + k) % 10;
                if (i == total - 1) {
                    i--;
                }
            }
            tem.next = new ListNode(t);
            k = (v1 + v2 + k) / 10;
            tem = tem.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return head.next;

    }

    //递归版本
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        return addTwoNumbers2(l1, l2, 0);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2, int a) {
        if (l1 == null && l2 == null) {
            return a == 0 ? null : new ListNode(a);
        }
        if (l1 != null) {
            a += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            a += l2.val;
            l2 = l2.next;
        }
        ListNode tem = new ListNode(a % 10);
        tem.next = addTwoNumbers2(l1, l2, a / 10);
        return tem;
    }

    //practice----------------溢出
    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        long temp1 = 0;
        int k = 0;
        while (l1 != null) {
            temp1 += Math.pow(10, k) * l1.val;
            l1 = l1.next;
            k++;
        }
        long temp2 = 0;
        k = 0;
        while (l2 != null) {
            temp2 += Math.pow(10, k) * l2.val;
            l2 = l2.next;
            k++;
        }
        long count = temp1 + temp2;
        if (count == 0) {
            return new ListNode(0);
        }
        ListNode head = new ListNode(-1);
        ListNode re = head;
        while (count != 0) {
            head.next = new ListNode((int) (count % 10));
            head = head.next;
            count /= 10;
        }

        return re.next;
    }
}

