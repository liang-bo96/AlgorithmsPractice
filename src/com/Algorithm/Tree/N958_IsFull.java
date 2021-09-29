package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

import java.util.LinkedList;

/**
 * 958. ����������ȫ�Լ���
 * ����һ����������ȷ�����Ƿ���һ����ȫ��������
 *
 * �ٶȰٿ��ж���ȫ�������Ķ������£�
 *
 * ��������������Ϊ h������ h ���⣬�������� (1��h-1) �Ľ�������ﵽ���������� h �����еĽ�㶼��������������ߣ��������ȫ����������ע���� h ����ܰ��� 1~ 2h ���ڵ㡣��
 *
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺[1,2,3,4,5,6]
 * �����true
 * ���ͣ����һ��ǰ��ÿһ�㶼�����ģ��������ֵΪ {1} �� {2,3} �����㣩�������һ���е����н�㣨{4,5,6}���������ܵ�����
 * ʾ�� 2��
 *
 *
 *
 * ���룺[1,2,3,4,5,null,7]
 * �����false
 * ���ͣ�ֵΪ 7 �Ľ��û�о����ܿ�����ࡣ
 */
public class N958_IsFull {
    //���������֤��һ�����߿յ��п϶��ᱻ�������ؽ���
    //���ֿ�֮����жϺ����Ƿ�ȫΪ�գ�ֻҪ��һ����Ϊ��˵��������ȫ������
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode cur;
        q.addLast(root);
        while ((cur = q.removeFirst()) != null) {
            q.addLast(cur.left);
            q.addLast(cur.right);
        }
        while (!q.isEmpty()) {
            if (q.removeLast() != null) {
                return false;
            }
        }
        return true;
    }
    //  ���!!!!!!!!!!!!!!!!!!!!!!!!!
    public static Info help(TreeNode root) {
        if (root == null) {
            return new Info(true, false);
        }
        if (root.left == null && root.right == null) {
            return new Info(true, false);
        }
        if (root.left == null) {
            return new Info(false, true);
        }
        if (root.right == null) {
            return new Info(true, true);
        }
        Info left = help(root.left);
        Info right = help(root.right);
        boolean isCompleteTree = left.isCompleteTree && right.isCompleteTree;
        if (left.isLack) {
            isCompleteTree = false;
        }
        return new Info(isCompleteTree, left.isLack || right.isLack);
    }

    static class Info {
        boolean isCompleteTree;
        boolean isLack;

        public Info(boolean isCompleteTree, boolean isLack) {
            this.isCompleteTree = isCompleteTree;
            this.isLack = isLack;
        }
    }
}
