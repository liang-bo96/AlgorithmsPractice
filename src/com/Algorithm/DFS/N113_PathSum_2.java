package com.Algorithm.DFS;

import com.Algorithm.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.Algorithm.Tree.RecursiveTravel.createTree;

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
        if (root.left == null && root.right == null){
//            if(sum == root.val){
                list.add(temp);
//            }
        }
        if(root.left != null){
            getSum(root.left,sum - root.val,new ArrayList<>(temp));
        }
        if(root.right != null){
            getSum(root.right,sum - root.val,new ArrayList<>(temp));
        }
    }
}
