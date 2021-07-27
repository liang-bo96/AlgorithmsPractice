package com.Algorithm.ReverseList;

import com.Algorithm.LinkedList.ListNode;

import static com.Algorithm.ReverseList.Basic.generateListNode;

public class FirstKReverse {
    public static void main(String[] args) {
        ListNode node = generateListNode();
//        System.out.println(firstKReverse(node, 3));
        System.out.println(KReverse(node, 2,4));

    }
    static ListNode tem = null;
    //反转前n个节点
    public static ListNode firstKReverse(ListNode head, int n){
        if(n == 1) {
            tem = head.next;
            return head;
        }
        ListNode last = firstKReverse(head.next, n - 1);
        head.next.next = head;
        head.next = tem;
        return last;
    }
    //反转前m到n个节点
    public static ListNode KReverse(ListNode head, int m , int n){
        if( m == 1){
            return firstKReverse(head,n);
        }
        head.next = KReverse(head.next,m-1,n - 1);
        return head;
    }
}
