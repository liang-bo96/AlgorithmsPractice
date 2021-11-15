package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. �����������е�KС��Ԫ��
 * ����һ�������������ĸ��ڵ� root ����һ������ k ���������һ���㷨�������е� k ����СԪ�أ��� 1 ��ʼ��������
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [3,1,4,null,2], k = 1
 * �����1
 * ʾ�� 2��
 *
 *
 * ���룺root = [5,3,6,2,4,null,null,1], k = 3
 * �����3
 */
public class N230_KthInBST {
    //reference
    public int kthSmallest(TreeNode root, int k) {
        l = new ArrayList<>();
        midtravel(root,l,k);
        return l.get(k - 1);
    }
    static List<Integer> l;
    public static void midtravel(TreeNode root, List<Integer> l, int k){
        if(root == null){
            return;
        }
        midtravel(root.left,l,k);
        l.add(root.val);
        if(l.size() == k){
            return;
        }
        midtravel(root.right,l,k);
    }
    /**
     * �����������ڵ����ΪleftN,���K<=leftN,�������ҽڵ�����������.
     * ��K=leftN+1,�������ҽڵ�Ϊ���ڵ�
     * ��K>leftN+1,�������ҽڵ�����������,����ͬ������������������K-leftN���ڵ�
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest1(TreeNode root, int k) {
        int leftN=findChild(root.left);
        if(leftN+1==k) return root.val;
        else if(k<=leftN){
            return kthSmallest1(root.left, k);
        }
        else return kthSmallest1(root.right, k-leftN-1);
    }
    /**
     *�����ӽڵ����
     * @param root
     * @return
     */
    public int findChild(TreeNode root){
        if(root==null) return 0;
        return findChild(root.left)+findChild(root.right)+1;
    }
}
