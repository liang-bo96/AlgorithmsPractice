package com.Algorithm.BFS;

import com.Algorithm.Tree.RecursiveTravel;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树层序遍历
public class N102_binary_tree_level_order_traversal {
    public static void main(String[] args) {
        TreeNode tree = new RecursiveTravel().createTree();
        System.out.println(new N102_binary_tree_level_order_traversal().levelOrder(tree));
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> tem = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                tem.add(poll.val);
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            result.add(tem);
        }
        return result;
    }

    public List<List<Integer>> levelOrder_Practice(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> temlist = new ArrayList<>();
            int size = queue.size();//重要
            for (int i = 0; i < size; i++) {
                TreeNode tem = queue.poll();
                temlist.add(tem.val);
                if(tem.left != null){
                    queue.add(tem.left);
                }
                if(tem.right!=null){
                    queue.add(tem.right);
                }
            }
            result.add(temlist);
        }
        return result;
    }
}
