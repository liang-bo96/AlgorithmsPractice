package com.company.FastSlowPointer;


import com.company.LinkedList.ListNode;

//检测链表是否有环
public class N141_DetectCycle {
    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;

        }
        return true;

    }

}
