package com.Algorithm.LinkedList_ReverseList;

import com.Algorithm.LinkedList.ListNode;

import java.util.List;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class N92_ReverseList {
    /**
     * Java 1ms，时间空间均90+。 实现思路 ：以1->2->3->4->5, left = 2, right=4 为例:
     *
     * 定位到要反转部分的头节点 2，head = 2；前驱结点 1，pre = 1；
     * 当前节点的下一个节点3调整为前驱节点的下一个节点 1->3->2->4->5,
     * 当前结点仍为2， 前驱结点依然是1，重复上一步操作。。。
     * 1->4->3->2->5.
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i = left; i < right; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }
}
