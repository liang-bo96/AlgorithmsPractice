package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 */
public class N230_KthInBST {
    //reference
    public int kthSmallest(TreeNode root, int k) {
        l = new ArrayList<>();
        midtravel(root,l,k);
        return l.get(k - 1);
    }
    static List<Integer> l;
    public static void midtravel(TreeNode root, List<Integer> l, int k){
        if(root == null){
            return;
        }
        midtravel(root.left,l,k);
        l.add(root.val);
        if(l.size() == k){
            return;
        }
        midtravel(root.right,l,k);
    }
    /**
     * 查找左子树节点个数为leftN,如果K<=leftN,则所查找节点在左子树上.
     * 若K=leftN+1,则所查找节点为根节点
     * 若K>leftN+1,则所查找节点在右子树上,按照同样方法查找右子树第K-leftN个节点
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest1(TreeNode root, int k) {
        int leftN=findChild(root.left);
        if(leftN+1==k) return root.val;
        else if(k<=leftN){
            return kthSmallest1(root.left, k);
        }
        else return kthSmallest1(root.right, k-leftN-1);
    }
    /**
     *查找子节点个数
     * @param root
     * @return
     */
    public int findChild(TreeNode root){
        if(root==null) return 0;
        return findChild(root.left)+findChild(root.right)+1;
    }
}
