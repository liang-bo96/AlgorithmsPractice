package com.Main;

import com.Algorithm.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        d.next = e;


        ListNode f =new ListNode(7);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(9);
        ListNode j = new ListNode(10);
        ListNode k = new ListNode(11);
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;
        j.next = k;
        ListNode[] t = new ListNode[4];
        t[0] = a;
        t[1] = f;
        t[2] = null;
        t[3] = null;
        System.out.println(new Main1().solve(t));
    }
    public ListNode solve (ListNode[] a) {
        ListNode head = new ListNode(-1);
        ListNode result = head;
//        ListNode[] headlist = new ListNode[a.length];
//        for(int i = 0; i < a.length; i++){
//            headlist[i] = a[i];
//        }
        for (int i = 0; i < 999; i++) {
            boolean flag = false;
            for (int j = 0; j < a.length; j++) {
                ListNode tem = a[j];
                if(tem != null){
                    flag = true;
                    a[j] = tem.next;
                    tem.next = null;
                    head.next =tem;
                    head = head.next;
                }
            }
            if(!flag){
                break;
            }
        }
        return result.next;
    }
}
