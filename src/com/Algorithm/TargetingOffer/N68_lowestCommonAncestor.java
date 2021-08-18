package com.Algorithm.TargetingOffer;

import com.Algorithm.BFS.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * �����������ڵ���͹�������
 */
public class N68_lowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(9);
        TreeNode e = new TreeNode(0);
        b.left = d;
        b.right = e;
//        d.left = c;
        d.right = a;
        System.out.println(new N68_lowestCommonAncestor().lowestCommonAncestor(b, e, a).val);
    }
    /**
     * �ݹ鷽��
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(exist(root.left,p) && exist(root.left,q)){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(exist(root.right,p) && exist(root.right,q)){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
    public boolean exist(TreeNode root, TreeNode p){
        if(root == null) return false;
        if(root.val == p.val){
            return true;
        }
        return exist(root.left,p) || exist(root.right,p);
    }
    /**
     *�򵥷������洢���׽ڵ�
     * ��ÿ���ڵ㸸�ڵ�洢������Ȼ��p��q������Ѱ�Ҹ��ڵ㣬��һ��������ǹ������ڵ�
     */
    static Map<TreeNode,TreeNode> parentMap;
    static Set<TreeNode> set;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parentMap = new HashMap<>();
        set = new HashSet<>();
        dfs(root);
        while(p != null){
            set.add(p);
            p = parentMap.get(p);
        }
        while(!set.contains(q)){
            q = parentMap.get(q);
        }
        return q;

    }
    public static void dfs(TreeNode root){
        if(root.left != null){
            parentMap.put(root.left,root);
            dfs(root.left);
        }
        if(root.right != null){
            parentMap.put(root.right,root);
            dfs(root.right);
        }
    }
}
