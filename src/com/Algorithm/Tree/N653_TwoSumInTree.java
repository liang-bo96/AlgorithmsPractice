package com.Algorithm.Tree;


import com.Algorithm.BFS.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 653. ����֮�� IV - ���� BST
 * ����һ������������ root ��һ��Ŀ���� k����� BST �д�������Ԫ�������ǵĺ͵��ڸ�����Ŀ�������򷵻� true��
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ����: root = [5,3,6,2,4,null,7], k = 9
 * ���: true
 * ʾ�� 2��
 *
 *
 * ����: root = [5,3,6,2,4,null,7], k = 28
 * ���: false
 */
public class N653_TwoSumInTree {
    public static void main(String[] args) {

    }

    //reference
    public boolean findTarget(TreeNode root, int k) {
        Set< Integer > set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}


