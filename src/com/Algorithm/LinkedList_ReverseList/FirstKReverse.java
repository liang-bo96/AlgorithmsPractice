package com.Algorithm.LinkedList_ReverseList;

import com.Algorithm.LinkedList.ListNode;

import java.util.List;

import static com.Algorithm.LinkedList_ReverseList.Basic.generateListNode;

public class FirstKReverse {
    public static void main(String[] args) {
        ListNode node = generateListNode();
        System.out.println(firstKReverse(node, 3));
        System.out.println(firstKReverse1(node, 3));

//        System.out.println(KReverse(node, 2, 4));

    }

    static ListNode tem = null;

    //反转前n个节点
    public static ListNode firstKReverse(ListNode head, int n) {
        if (n == 1) {
            tem = head.next;
            return head;
        }
        ListNode last = firstKReverse(head.next, n - 1);
        head.next.next = head;
        head.next = tem;
        return last;
    }

    //反转前m到n个节点
    public static ListNode KReverse(ListNode head, int m, int n) {
        if (m == 1) {
            return firstKReverse(head, n);
        }
        head.next = KReverse(head.next, m - 1, n - 1);
        return head;
    }


    //练习------------left到right反转
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right){
            return head;
        }
        ListNode dump = new ListNode(-1);
        ListNode result = dump;
        dump.next = head;
        for(int i = 0; i < left - 1; i++){
            dump = dump.next;
        }
        ListNode next = firstKReverse1(dump.next,right - left + 1);
        dump.next = next;
        return result.next;

    }
    public static ListNode firstKReverse1(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode oldhead = head;
        for (int i = 0; i < n; i++){
            head = head.next;
        }
        ListNode tail = head;
        for(int i = 0; i < n; i++){
            ListNode next = oldhead.next;
            oldhead.next = tail;
            tail = oldhead;
            oldhead = next;
        }
        return tail;
    }
}
