package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

import static com.Algorithm.Tree.RecursiveTravel.createTree1;

public class N226_ReverseBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new N226_ReverseBinaryTree().invertTree(createTree1());
        System.out.println(treeNode);
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
