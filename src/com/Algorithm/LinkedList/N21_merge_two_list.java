package com.Algorithm.LinkedList;

import java.util.List;

public class N21_merge_two_list {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(-1);
        ListNode tem = dump;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tem.next = l1;
                l1 = l1.next;
            } else {
                tem.next = l2;
                l2 = l2.next;
            }
            tem = tem.next;
        }
        if (l1 == null) {
            tem.next = l2;
        } else {
            tem.next = l1;
        }
        return dump.next;
    }

    //for practice
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dump = head;
        while(l1 != null && l2 != null ){
            if(l1.val < l2.val){
                dump.next = l1;
                l1 = l1.next;
            }else{
                dump.next = l2;
                l2 = l2.next;
            }
            dump = dump.next;
        }
        dump.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
