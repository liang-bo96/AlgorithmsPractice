package com.Algorithm.DFS;

import com.Algorithm.AAA.A;
import com.Algorithm.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;


import static com.Algorithm.Tree.RecursiveTravel.createTree;

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
        System.out.println(new N112_PathSum().hasPathSum3(createTree(), 12));
    }

    /******************************************method1************************************************/
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        getSum(root, 0);
        for (Integer t : list) {
            if (t == targetSum) {
                return true;
            }
        }
        return false;
    }

    static List<Integer> list = new ArrayList<>();

    public static void getSum(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            list.add(sum + root.val);
        }
        if (root.left != null) {
            getSum(root.left, sum + root.val);
        }
        if (root.right != null) {
            getSum(root.right, sum + root.val);
        }
    }

    /******************************************method2************************************************/
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }

    /**************************练习***********************************/
    /**
     * 求出根节点到所有叶子结点的路径
     */
    static List<List<Integer>> result;

    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if(root == null) return false;
        result = new ArrayList<>();
        process(root, new ArrayList<>());
        return judge(result, targetSum);
    }

    public static boolean judge(List<List<Integer>> list, int target) {
        for (List<Integer> l : list) {
            int count = 0;
            for (int i : l) {
                count += i;
            }
            if (count == target) {
                return true;
            }
        }
        return false;
    }

    public static void process(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            process(root.left, new ArrayList<>(list));
        }
        if (root.right != null) {
            process(root.right, new ArrayList<>(list));
        }
        list.remove(list.size() - 1);
    }

}
