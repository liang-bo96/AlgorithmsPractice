package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

/**
 * 98. ��֤����������
 * ����һ���������ĸ��ڵ� root ���ж����Ƿ���һ����Ч�Ķ�����������
 *
 * ��Ч �����������������£�
 *
 * �ڵ��������ֻ���� С�� ��ǰ�ڵ������
 * �ڵ��������ֻ���� ���� ��ǰ�ڵ������
 * �������������������������Ҳ�Ƕ�����������
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [2,1,3]
 * �����true
 */
public class N98_IsBST {
    //----------------------------------------------ref
    public boolean isValidBST(TreeNode root) {
        return help(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean help(TreeNode root,long min,long max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return help(root.left,min,root.val) && help(root.right,root.val,max);
    }
    // practice
    public boolean isValidBST1(TreeNode root) {
        return help(root).isValid;
    }
    public static IsBST help(TreeNode root){
        if(root == null){
            return new IsBST(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
        }
        IsBST left = help(root.left);
        IsBST right = help(root.right);
        int min = Math.min(Math.min(left.min,right.min), root.val);
        int max = Math.max(Math.max(left.max, right.max), root.val);
        boolean isValid = true;
        if(!left.isValid || !right.isValid || left.max >= root.val || right.min <= root.val){
            isValid = false;
        }
        return new IsBST(min,max,isValid);
    }
}
class IsBST{
    int min;
    int max;
    boolean isValid;

    public IsBST() {
    }

    public IsBST(int min, int max, boolean isValid) {
        this.min = min;
        this.max = max;
        this.isValid = isValid;
    }
}
