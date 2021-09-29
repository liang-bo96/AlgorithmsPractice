package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 *
 *
 * 示例 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class N105_BuildTreeByPreAndIn {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(new int[]{1, 2}, 0, 0)));
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null ||preorder.length == 0 || inorder.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        for (int j = 0; j < inorder.length; j++) {
            if(inorder[j] == preorder[0]){
                i = j;
                break;
            }
        }
        //inorder数组中根节点左侧数组长度和右侧数组长度
        int left = i ;
        int right = inorder.length - i - 1;

        root.left = buildTree(
                Arrays.copyOfRange(preorder,1,left + 1),
                Arrays.copyOfRange(inorder,0,i));
        root.right = buildTree(
                Arrays.copyOfRange(preorder,left + 1,left + right + 1),
                Arrays.copyOfRange(inorder,i+1,inorder.length));
        return root;
    }
}
