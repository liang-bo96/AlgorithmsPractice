package com.Algorithm.BFS;

import com.Algorithm.Tree.RecursiveTravel;

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
}
