package com.Algorithm.LinkedList;

/**
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 */
public class N328_JiOuLianBiao {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(oddEvenList(a));
    }
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // head 为奇链表头结点，o 为奇链表尾节点
        ListNode firstTail = head;
        // p 为偶链表头结点
        ListNode secondHead = head.next;
        // e 为偶链表尾节点
        ListNode SecondTail = secondHead;
        while (firstTail.next != null && SecondTail.next != null) {
            firstTail.next = SecondTail.next;
            firstTail = firstTail.next;
            SecondTail.next = firstTail.next;
            SecondTail = SecondTail.next;
        }
        firstTail.next = secondHead;
        return head;
    }
}
