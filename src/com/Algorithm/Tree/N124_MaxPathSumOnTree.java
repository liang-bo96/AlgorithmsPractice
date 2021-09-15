package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 */
public class N124_MaxPathSumOnTree {
    static int result;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        process(root);
        return result;
    }

    public static int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, process(root.left));
        int right = Math.max(0, process(root.right));
        result = Math.max(result, left + right + root.val);
        return root.val + Math.max(left, right);
    }

    //practice
    //错误的，该方法只能寻找从上到下某条路径的最大值
    static int result1;

    public int maxPathSum1(TreeNode root) {
        result1 = 0;
        travel(root, 0);
        if (root.left != null) {
            maxPathSum1(root.left);
        }
        if (root.right != null) {
            maxPathSum1(root.right);
        }
        return result1;
    }

    public static void travel(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        result1 = Math.max(result1, sum);
        travel(root.left, sum);
        travel(root.right, sum);
    }
}
