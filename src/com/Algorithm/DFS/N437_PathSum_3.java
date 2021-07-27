package com.Algorithm.DFS;

import com.Algorithm.BFS.TreeNode;

/*
* 437. 路径总和 III
给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

示例：

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
* */
public class N437_PathSum_3 {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(5);

        TreeNode b1 = new TreeNode(4);
        TreeNode b2 = new TreeNode(8);

        TreeNode c1 = new TreeNode(11);
        TreeNode c2 = new TreeNode(13);
        TreeNode c3 = new TreeNode(4);

        TreeNode d1 = new TreeNode(998);
        TreeNode d2 = new TreeNode(2);
        TreeNode d3 = new TreeNode(5);
        TreeNode d4 = new TreeNode(1);

        a1.left = b1; a1.right = b2;

        b1.left = c1; b2.left = c2;b2.right = c3;

        c1.left = d1;c2.right = d2;c3.left = d3;c3.right = d4;
        System.out.println(new N437_PathSum_3().pathSum(a1,2));

    }
    public int pathSum(TreeNode root, int targetSum) {
        travel(root,targetSum);
        return result;
    }
    public static void travel(TreeNode root,int target){
        getSum(root, root.val, target);
        if(root.left != null){
            travel(root.left,target);
        }
        if(root.right != null){
            travel(root.right,target);
        }
    }
    static int result;
    public static void getSum(TreeNode root,int sum,int target){
        if(sum == target){
            result++;
        }
        if(root == null) return;
        if(root.left != null){
            getSum(root.left,sum + root.left.val,target);
        }
        if(root.right != null){
            getSum(root.right,sum + root.right.val,target);
        }
    }

}
