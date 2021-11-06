package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * 129. ����ڵ㵽Ҷ�ڵ�����֮��
 * ����һ���������ĸ��ڵ� root ������ÿ���ڵ㶼�����һ�� 0 �� 9 ֮������֡�
 * ÿ���Ӹ��ڵ㵽Ҷ�ڵ��·��������һ�����֣�
 * <p>
 * ���磬�Ӹ��ڵ㵽Ҷ�ڵ��·�� 1 -> 2 -> 3 ��ʾ���� 123 ��
 * ����Ӹ��ڵ㵽Ҷ�ڵ����ɵ� ��������֮�� ��
 * <p>
 * Ҷ�ڵ� ��ָû���ӽڵ�Ľڵ㡣
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺root = [1,2,3]
 * �����25
 * ���ͣ�
 * �Ӹ���Ҷ�ӽڵ�·�� 1->2 �������� 12
 * �Ӹ���Ҷ�ӽڵ�·�� 1->3 �������� 13
 * ��ˣ������ܺ� = 12 + 13 = 25
 * ʾ�� 2��
 * <p>
 * <p>
 * ���룺root = [4,9,0,5,1]
 * �����1026
 * ���ͣ�
 * �Ӹ���Ҷ�ӽڵ�·�� 4->9->5 �������� 495
 * �Ӹ���Ҷ�ӽڵ�·�� 4->9->1 �������� 491
 * �Ӹ���Ҷ�ӽڵ�·�� 4->0 �������� 40
 * ��ˣ������ܺ� = 495 + 491 + 40 = 1026
 */
public class N129_SumNumRootLeaf {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(9);
        TreeNode e = new TreeNode(0);
//        b.left = d;
//        b.right = e;
//        d.left = c;
//        d.right = a;
        a.left = e;
        System.out.println(new N129_SumNumRootLeaf().sumNumbers(a));
    }
    static List<List<Integer>> list;

    public int sumNumbers(TreeNode root) {
        list = new ArrayList<>();
        process(new ArrayList<>(), root);
        return total(list);
    }

    public static void process(List<Integer> tem, TreeNode root) {
        if (root.left == null && root.right == null) {
            tem.add(root.val);
            list.add(new ArrayList<>(tem));
            tem.remove(tem.size() - 1);
            return;
        }
        tem.add(root.val);
        if (root.left != null) {
            process(tem, root.left);
        }
        if (root.right != null) {
            process(tem, root.right);
        }
        tem.remove(tem.size() - 1);
    }

    public static int total(List<List<Integer>> t) {
        int result = 0;
        for (List<Integer> tem : t) {
            for (int i = tem.size() - 1; i >= 0; i--) {
                result += tem.get(i) * Math.pow(10, tem.size() - i - 1);
            }
        }
        return result;
    }


    /**
     * �ݹ��׼��
     *
     * @param root
     * @return
     */
    public int sumNumbers1(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
