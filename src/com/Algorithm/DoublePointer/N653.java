package com.Algorithm.DoublePointer;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class N653 {
    public static void main(String[] args) {

    }



    //reference
    public boolean findTarget1(TreeNode root, int k) {
        Set< Integer > set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }



    public boolean findTarget2(TreeNode root, int k) {
        int[] tem = new int[ref.size()];
        for(int i = 0 ; i < ref.size(); i++){
            tem[i] = ref.get(i);
        }
        for(int i = 0; i < tem.length; i++){
            for (int j = i + 1; j < tem.length; j++) {
                if(tem[i] + tem[j] == k){
                    return true;
                }
            }
        }
        return false;
    }
    static List<Integer> ref;
    public static void travel(TreeNode root){
        if(root == null) return;
        ref.add(root.val);
        travel(root.left);
        travel(root.right);
    }


}


