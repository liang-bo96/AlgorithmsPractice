package com.Algorithm.LinkedList;

/**
 * ���������ͷ���?head?���뽫�䰴 ���� ���в����� ���������� ��
 *
 * ���ף�
 *
 * �������?O(n?log?n) ʱ�临�ӶȺͳ������ռ临�Ӷ��£����������������
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sort-list
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class N148_SortList {
    /**
     * �ο���Sort List�������䣨�����еĹ鲢���� https://www.cnblogs.com/qiaozhoulin/p/4585401.html
     *
     * �鲢���򷨣��ڶ���֮ǰһֱ���ÿռ临�Ӷ�Ϊ������̫���ܣ���Ϊԭ��ʹ�ù鲢ʱ������ O(N)�ģ�
     * ��Ҫ���Ƴ���ȵĿռ������и�ֵ�鲢����������ʵ�����ǿ���ʵ�ֳ����ռ�ռ�õģ�����Ĺ鲢
     * ������Ҫ����Ŀռ䣩�����ù鲢��˼�룬�ݹ�ؽ���ǰ�����Ϊ���Σ�Ȼ��merge�������εķ�
     * ����ʹ�� fast-slow ����������ָ�룬һ��ÿ����������һ����һ����֪������ߵ���ĩβ��Ȼ��
     * ��������λ�þ����м�λ�ã������ͷֳ������Ρ�mergeʱ��������ͷ���ڵ�ֵ�Ƚϣ���һ�� p ָ��
     * ��С�ģ��Ҽ�¼��һ���ڵ㣬Ȼ�� ���ε�ͷһ��һ������ߣ�pҲһֱ����ߣ�����ָ���С�ڵ㣬
     * ֱ������һ��ͷΪNULL������ʣ�µ�Ԫ�ء���󷵻ؼ�¼��ͷ���ɡ�
     *
     * ��Ҫ����3��֪ʶ�㣬
     * ֪ʶ��1���鲢���������˼��
     * ֪ʶ��2���ҵ�һ��������м�ڵ�ķ���
     * ֪ʶ��3���ϲ��������ź��������Ϊһ���µ���������
     */
    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);
        return merge(l, r);
    }

    public ListNode merge(ListNode l, ListNode r) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return dummyHead.next;
    }
}
