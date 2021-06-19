package com.company.DFS;

import com.company.BFS.TreeNode;
import com.company.Tree.SerAndUnserTree;
import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
