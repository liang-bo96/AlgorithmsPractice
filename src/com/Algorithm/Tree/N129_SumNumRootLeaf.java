package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
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
     * 递归辨准答案
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
