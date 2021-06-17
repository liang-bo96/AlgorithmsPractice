package com.company.FastSlowPointer;

import com.company.LinkedList.ListNode;
/*
 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

输入：
{1,2,3,3,4,4,5}

返回值：
{1,2,5}

* */
public class DeleteListNodeDuplication {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null) return pHead;
        //设置虚拟头节点
        ListNode dump = new ListNode(0);
        dump.next = pHead;
        ListNode pre = dump;
        ListNode last = dump.next;
        while(last != null){
            if(last.next != null && last.val == last.next.val){
                while(last.next != null && last.val == last.next.val){
                    last = last.next;
                }
                last = last.next;
                pre.next = last;
            }else{
                pre = pre.next;
                last = last.next;
            }
        }
        return dump.next;
    }
}
