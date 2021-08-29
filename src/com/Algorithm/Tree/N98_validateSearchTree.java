package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

import java.util.TreeMap;

public class N98_validateSearchTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(0);
        a.left = b;
        new N98_validateSearchTree().isValidBST(a);
    }
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }
        return getInfo(root).isValidBST;
    }
    public static Info getInfo(TreeNode root){
        if(root == null){
            return null;
        }
        Info left = getInfo(root.left);
        Info right = getInfo(root.right);
        int min = Integer.MAX_VALUE;
        if(left != null){
            min = Math.min(min, left.min);
        }
        if(right != null){
            min = Math.min(min, right.min);
        }
        int max = Integer.MIN_VALUE;
        if(left != null){
            max = Math.max(max, left.max);
        }
        if(right != null){
            max = Math.max(max, right.max);
        }
        boolean isValidBST = true;
        if(left != null && !left.isValidBST){
            isValidBST = false;
        }
        if(right != null && !right.isValidBST){
            isValidBST = false;
        }
        if(left != null && left.max >= root.val){
            isValidBST = false;
        }
        if(right != null && right.min <= root.val){
            isValidBST = false;
        }
        return new Info(max,min,isValidBST);
    }
    static class Info{
        public int max;
        public int min;
        public boolean isValidBST;

        public Info() {
        }

        public Info(int max, int min, boolean isValidBST) {
            this.max = max;
            this.min = min;
            this.isValidBST = isValidBST;
        }

        public Info(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
}

