package com.Algorithm.DFS;

import com.Algorithm.BFS.TreeNode;

public class T26_SubStructureOfTree {
    public static void main(String[] args) {

    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return isSame(A,B) ||isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    public static boolean isSame(TreeNode a,TreeNode b){
        if(a == null && b == null || a != null && b == null) return true;
        if(a == null && b != null) return false;
        return a.val == b.val && isSame(a.left,b.left) && isSame(a.right,b.right);
    }
}
