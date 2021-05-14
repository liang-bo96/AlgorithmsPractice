package com.company.Casual;

import java.util.*;

 class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *

     * @return ListNode类
     */
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(-1);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(3);
        a.next=b;
        b.next = c;
        d.next=e;
        e.next=f;
        System.out.println(new Solution().minusList(a, d));
    }
    public ListNode minusList (ListNode minuendList, ListNode subtrahendList) {
        // write code here
        int len1 = 0;
        int len2 = 0;
        int len3 = 1;
        int len4 = 1;
        ListNode first = minuendList;
        ListNode second = subtrahendList;
        while(minuendList != null){
            len3 = len3 * minuendList.val;
            len1++;
            minuendList = minuendList.next;
        }
        while(subtrahendList != null){
            len4 = len4 * subtrahendList.val;
            len2++;
            subtrahendList = subtrahendList.next;
        }
        int a = 0;
        int b = 0;
        while(first != null){
            a += Math.pow(10,len1-1)*Math.abs(first.val);
            len1--;
            first = first.next;
        }
        while(second != null){
            b+=Math.pow(10,len2-1)*Math.abs(second.val);
            len2--;
            second = second.next;
        }
        if(len3<0) a = a*-1;
        if(len4<0) b = b*-1;
        int tem = a-b;
        Stack<Integer> stack = new Stack<>();
        while(tem != 0){
            stack.push(tem%10);
            tem = tem /10;
        }
        ListNode start = new ListNode(stack.pop());
        ListNode t = new ListNode(1);
        ListNode k = new ListNode(1);
        k.next = start;
        while(!stack.isEmpty()){
            t = new ListNode(stack.pop());
            start.next = t;
            start = start.next;
        }
        return k.next;

    }
}