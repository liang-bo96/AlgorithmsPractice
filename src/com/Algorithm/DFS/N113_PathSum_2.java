package com.Algorithm.DFS;

import com.Algorithm.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.Algorithm.Tree.RecursiveTravel.createTree;

/**
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 */
public class N113_PathSum_2 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.setLeft(t2);
        t1.setRight(t3);
//        System.out.println(new N113_PathSum_2().pathSum(t1, 3));
        System.out.println(new N113_PathSum_2().pathSum(createTree(), 3));
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        list = new ArrayList<>();
        if(root == null) return list;
        getSum(root,targetSum,new ArrayList<>());
        return list;
    }
    static List<List<Integer>> list;
    public static void getSum(TreeNode root,int sum,List<Integer> temp){
        temp.add(root.val);
        if (root.left == null && root.right == null && sum == root.val){
                list.add(temp);
        }
        if(root.left != null){
            getSum(root.left,sum - root.val,new ArrayList<>(temp));
        }
        if(root.right != null){
            getSum(root.right,sum - root.val,new ArrayList<>(temp));
        }
    }
}
