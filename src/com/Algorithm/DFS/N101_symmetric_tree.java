package com.Algorithm.DFS;

import com.Algorithm.BFS.TreeNode;

public class N101_symmetric_tree {
    public static void main(String[] args) {
//        TreeNode head = SerAndUnserTree.BuildSerlizableTree();
//        System.out.println(new N101_symmetric_tree().isSymmetric(head));
    }
    public boolean isSymmetric(TreeNode root) {
        return help(root.left,root.right);
    }

    public static boolean help(TreeNode left,TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        return left.val == right.val
                &&help(left.left,right.right) &&help(left.right,right.left);
    }
}
