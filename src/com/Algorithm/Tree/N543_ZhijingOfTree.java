package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

/**
 * 543. ��������ֱ��
 * ����һ�ö�����������Ҫ��������ֱ�����ȡ�һ�ö�������ֱ�������������������·�������е����ֵ������·�����ܴ���Ҳ���ܲ���������㡣
 *
 *
 *
 * ʾ�� :
 * ����������
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * ���� 3, ���ĳ�����·�� [4,2,1,3] ���� [5,2,1,3]��
 */
public class N543_ZhijingOfTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        return help(root).value;
    }
    public Info help(TreeNode root){
        if(root == null){
            return new Info(0, 0);
        }
        Info left = help(root.left);
        Info right = help(root.right);
        return new Info(Math.max(left.height, right.height) + 1,
                Math.max(Math.max(left.value, right.value), left.height + right.height));
    }
    static class Info{
        int height;
        int value;

        public Info(int height, int value) {
            this.height = height;
            this.value = value;
        }
    }
}
