package com.Algorithm.LinkedList_FastSlowPointer;

import com.Algorithm.LinkedList.ListNode;

import java.util.List;

/*
 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

输入：
{1,2,3,3,4,4,5}

返回值：
{1,2,5}

* */
public class DeleteListNodeDuplication {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(new DeleteListNodeDuplication().deleteDuplication1(a));
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        //设置虚拟头节点
        ListNode dump = new ListNode(0);
        dump.next = pHead;
        ListNode pre = dump;
        ListNode last = dump.next;
        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                last = last.next;
                pre.next = last;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return dump.next;
    }

    //for practices
    public ListNode deleteDuplication1(ListNode pHead) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode dump = new ListNode(0);
        dump.next = pHead;
        ListNode left = pHead;
        ListNode right = dump;
        while(left != null){
            if(left.next != null &&left.val == left.next.val){
                while(left.next != null && left.val == left.next.val){
                    left = left.next;
                }
                left = left.next;
                right.next = left;
            }else{
                right = right.next;
                left = left.next;
            }
        }
        return dump.next;
    }
}
