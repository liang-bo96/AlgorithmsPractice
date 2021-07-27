package com.Algorithm.DFS;
/*
* 剑指 Offer 33. 二叉搜索树的后序遍历序列
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。



参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true*/
public class T33_verifyPostorder {
    public static void main(String[] args) {
        System.out.println(new T33_verifyPostorder().verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }
    //数组内部排列方式为【左子树|右子树|根】
    // 先判断左子树是否都小于根，
    // 然后判断右子树是否都大于根，
    // 符合要求后将左右子树递归进行判断
    public boolean verifyPostorder(int[] postorder) {
        return help(postorder,0, postorder.length - 1);
    }
    public static boolean help(int[] posOrder,int start,int end){
        if(start >= end) return true;
        int first_start = start;
        while(posOrder[start] < posOrder[end]){
            start++;
        }
        int mid = start;
        while(posOrder[start] > posOrder[end]){
            start++;
        }
        return start == end && help(posOrder,first_start,mid - 1) && help(posOrder,mid,end - 1);
    }
}
