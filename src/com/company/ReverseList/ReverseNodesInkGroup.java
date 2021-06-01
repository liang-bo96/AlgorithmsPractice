package com.company.ReverseList;

import static com.company.ReverseList.Basic.generateListNode;
/*
*25. K 个一组翻转链表
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

进阶：

你可以设计一个只使用常数额外空间的算法来解决此问题吗？
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。


示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
示例 2：


输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]
示例 3：

输入：head = [1,2,3,4,5], k = 1
输出：[1,2,3,4,5]
示例 4：

输入：head = [1], k = 1
输出：[1]
*
* */
public class ReverseNodesInkGroup {
    public static void main(String[] args) {
        ListNode head = generateListNode();
        ListNode newHead = ReverseKListNode(head, 2);
        while(newHead != null){
            System.out.println(newHead);
            newHead = newHead.next;
        }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = head;
        ListNode pos = head;
        for (int i = 0; i < k; i++) {
            if(pos == null){
                return pre;
            }
            pos = pos.next;
        }
        ListNode newHead = RrverseAtoB(pre, pos);
        pre.next = reverseKGroup(pos,k);
        return newHead;
    }
    public static ListNode RrverseAtoB(ListNode a, ListNode b){
        ListNode pre = null;
        ListNode cur = a;
        while(cur != b){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    //练习
    public static ListNode ReverseKListNode(ListNode head,int k){
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if(end == null){
                return start;
            }
            end = end.next;
        }
        ListNode newHead = RrverseAtoB(start, end);
        start.next = ReverseKListNode(end,k);
        return newHead;
    }
}
