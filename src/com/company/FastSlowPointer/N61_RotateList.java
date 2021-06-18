package com.company.FastSlowPointer;

import com.company.LinkedList.ListNode;

import java.util.List;
/*
* 61. 旋转链表
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

示例 1：

输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]
示例 2：


输入：head = [0,1,2], k = 4
输出：[2,0,1]


提示：

链表中节点的数目在范围 [0, 500] 内
-100 <= Node.val <= 100
0 <= k <= 2 * 109*/
public class N61_RotateList {
    public static void main(String[] args) {

    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int len = 0;
        ListNode slow = head;
        ListNode dump = head;
        while(head != null){
            head = head.next;
            len++;
        }
        int rotate_right = k % len;
        if(rotate_right == 0) return slow;
        for (int i = 0; i < len - rotate_right - 1; i++) {
            slow = slow.next;
        }
        ListNode tem = slow;
        slow = slow.next;
        tem.next = null;
        ListNode fast = slow;
        while(fast.next != null){
            fast = fast.next;
        }
        fast.next = dump;
        return slow;
    }
}
