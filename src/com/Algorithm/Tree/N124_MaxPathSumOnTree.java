package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

/**
 * 124. �������е����·����
 * ·�� ������Ϊһ������������ڵ�������ظ��ڵ�-�ӽڵ����ӣ��ﵽ����ڵ�����С�ͬһ���ڵ���һ��·�������� �������һ�� ����·�� ���ٰ���һ�� �ڵ㣬�Ҳ�һ���������ڵ㡣
 *
 * ·���� ��·���и��ڵ�ֵ���ܺ͡�
 *
 * ����һ���������ĸ��ڵ� root �������� ���·���� ��
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [1,2,3]
 * �����6
 * ���ͣ�����·���� 2 -> 1 -> 3 ��·����Ϊ 2 + 1 + 3 = 6
 * ʾ�� 2��
 *
 *
 * ���룺root = [-10,9,20,null,null,15,7]
 * �����42
 * ���ͣ�����·���� 15 -> 20 -> 7 ��·����Ϊ 15 + 20 + 7 = 42
 */
public class N124_MaxPathSumOnTree {
    static int result;
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        process(root);
        return result;
    }

    public static int process(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0,process(root.left));
        int right = Math.max(0,process(root.right));
        result = Math.max(result,left + right + root.val);
        return root.val + Math.max(left,right);

    }
}
