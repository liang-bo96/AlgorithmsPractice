package com.company.KMerge;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TestKMerge {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode b1 = new ListNode(3);
        ListNode c1 = new ListNode(4);
        ListNode a2 = new ListNode(3);
        ListNode b2 = new ListNode(5);
        ListNode c2 = new ListNode(6);
        ListNode a3 = new ListNode(6);
        ListNode b3 = new ListNode(7);
        ListNode c3 = new ListNode(7);
        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        b2.next = b3;
        c1.next = c2;
        c2.next = c3;
        List<Integer> list = new ArrayList<>();
        PriorityQueue<ListNode> queue = new PriorityQueue<>(3,(a,b) ->(a.val - b.val));
        queue.add(a1);
        queue.add(b1);
        queue.add(c1);
        while(!queue.isEmpty()){
            ListNode tem = queue.poll();
            list.add(tem.val);
//            System.out.println(tem.val);
            if(tem.next != null){
                queue.add(tem.next);
            }
        }
        System.out.println(list);
    }
}
class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
