package com.Algorithm.Tree;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 */

import java.util.HashMap;

/**
 * 结题思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，当
 * 1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，
 * 同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，
 * 所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
 */
public class N96_UniqueBST {
    public static void main(String[] args) {
        //1 2 3
        //1 2 5
    }
    public int numTrees(int n) {
        return help(n,new HashMap<Integer, Integer>());
    }
    public static int help(int n, HashMap<Integer, Integer> map){
        if(map.containsKey(n)){
            return map.get(n);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += help(i,map) * help(n-1 - i,map);
        }
        map.put(n,res);
        return res;
    }
}
