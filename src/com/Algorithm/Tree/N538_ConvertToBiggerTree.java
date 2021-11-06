package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

/**
 * ����һ���������������뽫����ÿ���ڵ��ֵ�滻�����д��ڻ��ߵ��ڸýڵ�ֵ�����нڵ�ֵ֮�͡�
 *
 * ����һ�£�������������������Լ��������
 *
 * �ڵ���������������� С�� �ڵ���Ľڵ㡣
 * �ڵ���������������� ���� �ڵ���Ľڵ㡣
 * ��������Ҳ�����Ƕ�����������
 * ע�⣺����Ŀ�� 538:?https://leetcode-cn.com/problems/convert-bst-to-greater-tree/? ��ͬ
 *
 * ?
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * �����[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class N538_ConvertToBiggerTree {
    int sum = 0;
    //����������������� -> �Ӵ�С ->�����ۼӸ��ڵ���ֵ����µ�ǰ�ڵ���ֵ
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
