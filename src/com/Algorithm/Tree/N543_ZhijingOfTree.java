package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
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
