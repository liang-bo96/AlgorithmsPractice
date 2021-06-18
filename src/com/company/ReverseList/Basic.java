package com.company.ReverseList;

import com.company.LinkedList.ListNode;

public class Basic {

    public static ListNode generateListNode(){
        ListNode a1 = new  ListNode(1);
        ListNode b1 = new  ListNode(2);
        ListNode c1 = new  ListNode(3);
        ListNode d1 = new  ListNode(4);
        ListNode e1 = new  ListNode(5);
        ListNode f1 = new  ListNode(6);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;
        e1.next = f1;
        return  a1;
    }

    public static void main(String[] args) {
        ListNode node = generateListNode();
//        System.out.println(BasicreverseList(node));
        System.out.println(reverseList(node));
    }

    public static ListNode BasicReverseList(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode reverseList(ListNode head){
        if(head.next == null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    public static ListNode BasicreverseList(ListNode head) {
         ListNode first = null;
         while(head != null){
             ListNode next = head.next;
             // first.next = null;
             head.next = first;
             first = head;
             head = next;
         }
         return first;
    }
    public static ListNode reverseList1(ListNode head) {
        //递归解法
        if(head == null || head.next == null) return head;
        if(head.next == null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}


