package com.Algorithm.LinkedList;

import java.util.ArrayList;
import java.util.Stack;

public class LinkListDemo {
    public static void main(String[] args) {
        Node first = new Node("first");
        Node second = new Node("second");
        Node third = new Node("third");
        ListNode f1 = new ListNode(1);
        ListNode f2 = new ListNode(1);
        ListNode f3 = new ListNode(1);
        ListNode f4 = new ListNode(4);
        f1.setNext(f2);
        f2.setNext(f3);
        f3.setNext(f4);
        deleteDuplication(f1);

//        System.out.println(printListFromTailToHead(f1));


        first.setNext(second);
        second.setNext(third);
        System.out.println(first);
        System.out.println(first.getNext());
        System.out.println(first.getNext().getNext());
        System.out.println(GetNumberOfK(new int[]{1,2,3,3,3,3,4,5}, 3));
        integerBreak(4);
        ReverseList(f1);
    }
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
//         ListNode first = new ListNode(1);
//         first.next = pHead;
//         ListNode cur = pHead;
//         ListNode be = first;
//         while(cur!=null){
//             if(cur.next!= null&&cur.val == cur.next.val){
//         while(cur.next!= null&&cur.val == cur.next.val){
//                 cur = cur.next;
//                 }
//                 cur = cur.next;
//             be.next = cur;
//         }else{
//                 cur = cur.next;
//                 be = be.next;
//             }
//             }
//         return first.next;
        ListNode head = new ListNode(0);
        ListNode root = new ListNode(0);
        root.next = pHead;
        head.next = pHead;
        while (head.next.next != null) {
            if (head.next.val == head.next.next.val) {
//                 while(head.next.val == head.next.next.val){
                head.next = head.next.next.next;
//                 }
            } else {
                head = head.next;
            }
        }
        return root.next;

    }

        public static  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 头插法构建逆序链表
//        ListNode head = new ListNode(-1);
//        while (listNode != null) {
//            ListNode memo = listNode.next;
//            listNode.next = head.next;
//            head.next = listNode;
//            listNode = memo;
//        }
//        // 构建 ArrayList
//        ArrayList<Integer> ret = new ArrayList<>();
//        head = head.next;
//        while (head != null) {
//            ret.add(head.val);
//            head = head.next;
//        }
//        return ret;
        ArrayList<Integer> l = new ArrayList<Integer>();


        ListNode head = new ListNode(-1);
        ListNode first = listNode;
        ListNode second = listNode.next;
        while(first != null){
            first.next = head.next;
            head.next = first;
            first = second;
            second = second.next;

        }
        head = head.next;
        while(head !=null){
            l.add(head.val);
            head = head.next;
        }
        return l;
    }
    public static int integerBreak(int n) {


        if(n<2)
            return 0;
        if(n==2)
            return 1;
        if(n ==3)
            return 2;


        int[] re = new int[n+1];

        re[0] = 0;
        re[1] = 0;
        re[2] = 1;
        re[3] = 2;
        for(int i = 4;i<=n;i++){
            int max = 0;
            for(int j = 1;j<=i/2;j++){
                if(re[j]*re[i-j]>max)
                    max = re[j] * re[i-j];
            }
            re[i] =max;
        }
        return re[n];
    }
    public static int GetNumberOfK(int [] nums , int k) {


            int l = 0, h = nums.length;
            while (l < h) {
                int m = l + (h - l) / 2;
                if (nums[m] >= k)
                    h = m;
                else
                    l = m + 1;
            }
            return l;
    }
    public static  ListNode ReverseList(ListNode head) {
        Stack<Integer> s = new Stack<>();
        while(head!=null){
            s.push(head.val);
            head = head.next;
        }
        ListNode head1 = new ListNode(-1);
        ListNode re = head1;
        while(!s.isEmpty()){
            re.next.val = s.pop();
            re = re.next;
        }
        return head1.next;
    }
}






class Node{
    private String name;
    private Node next;

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name ;
    }

    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
