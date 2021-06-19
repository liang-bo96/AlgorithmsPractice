package com.company.DFS;

import com.company.BFS.TreeNode;
import edu.princeton.cs.algs4.In;

//二叉树最小深度
public class N111_min_depth_of_tree {
    public static void main(String[] args) {

    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left_height = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int right_height = root.right != null ? minDepth(root.right):Integer.MAX_VALUE;
        return Math.min(left_height,right_height) + 1;
    }
}
