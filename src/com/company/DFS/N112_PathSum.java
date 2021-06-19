package com.company.DFS;

import com.company.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

//给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/path-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class N112_PathSum {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.setRight(t2);

        System.out.println(new N112_PathSum().hasPathSum(t1, 1));
    }
    /******************************************method1************************************************/
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        getSum(root,0);
        for(Integer t : list){
            if(t == targetSum){
                return true;
            }
        }
        return false;
    }
    static List<Integer> list = new ArrayList<Integer>();
    public static void getSum(TreeNode root,int sum){
        if (root.left == null && root.right == null){
           list.add(sum+root.val);
        }
        if(root.left != null){
            getSum(root.left,sum + root.val);
        }
        if(root.right != null){
            getSum(root.right,sum + root.val);
        }
    }
    /******************************************method2************************************************/
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }
        return hasPathSum2(root.left,targetSum - root.val) || hasPathSum2(root.right,targetSum - root.val);
    }

}
