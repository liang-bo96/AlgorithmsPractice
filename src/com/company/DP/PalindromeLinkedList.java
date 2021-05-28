package com.company.DP;

/**
 *234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * */

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
}
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(new PalindromeLinkedList().isPalindrome(a));
    }
    static ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return help(head);
    }
    public boolean help(ListNode head){
        if(head == null) return true;
        boolean flag = help(head.next);
        flag = flag && (head.val == left.val);
        left = left.next;
        return flag;
    }
}
