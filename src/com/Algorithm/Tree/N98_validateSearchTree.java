package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class N98_validateSearchTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(0);
        a.left = b;
        System.out.println(new N98_validateSearchTree().isValidBST(a));
    }
    //----------------------------references
    public boolean isValidBST(TreeNode root) {
        return help(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean help(TreeNode root,long min,long max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return help(root.left,min,root.val) && help(root.right,root.val,max);
    }
}

