package com.company.Leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class N160 {




    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(8);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);
        d.next =e;
        e.next = f;
        f.next = g;
        a.next =d;
        b.next = c;
        c.next = d;
        System.out.println(getIntersectionNode(a, b));

    }

        public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            // if(headA == null || headB == null) return null;
            // HashSet<ListNode> s = new HashSet<>();
            // while(headA != null){
            //     s.add(headA);
            //     headA = headA.next;
            // }
            // while(headB != null){
            //     if(s.contains(headB)){
            //         return headB;
            //     }
            //     headB = headB.next;
            // }
            // return null;
            if(headA == null || headB == null) return null;
            int lena = 0;
            int lenb = 0;
            ListNode A = new ListNode(0);
            ListNode B = new ListNode(0);
            A.next = headA;
            B.next = headB;

            while(headA != null){
                lena++;
                headA = headA.next;
            }
            while(headB != null){
                lenb++;
                headB = headB.next;
            }
            headA = A.next;
            headB = B.next;
            if(lena - lenb >=0){
                for(int i = 0 ; i < lena - lenb ; i++){
                    headA = headA.next;
                }
            }else{
                for(int i = 0 ; i < lenb - lena ; i++){
                    headB = headB.next;
                }
            }
            headA = A.next;
            headB = B.next;
            while(headA!=null){
                if(headA == headB){
                    return headB;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;

        }
    }

