package com.company.LinkedList;

public class ListNode {
    public int val;
    public ListNode next = null;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }
}
