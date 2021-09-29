package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

import java.util.LinkedList;

/**
 * 958. 二叉树的完全性检验
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 *
 * 百度百科中对完全二叉树的定义如下：
 *
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * 示例 2：
 *
 *
 *
 * 输入：[1,2,3,4,5,null,7]
 * 输出：false
 * 解释：值为 7 的结点没有尽可能靠向左侧。
 */
public class N958_IsFull {
    //层序遍历保证第一个出线空的行肯定会被完整加载进来
    //出现空之后就判断后面是否全为空，只要有一个不为空说明不是完全二叉树
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
    //  错的!!!!!!!!!!!!!!!!!!!!!!!!!
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
