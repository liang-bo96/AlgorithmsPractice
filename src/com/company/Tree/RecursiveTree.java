package com.company.Tree;

import com.company.BFS.TreeNode;

public class RecursiveTree extends RecursiveTravel{
    public static void main(String[] args) {
        RecursiveTree recursiveTree = new RecursiveTree();
        TreeNode root = recursiveTree.createTree();
        Info info = recursiveTree.TreeIsBalance(root);
        System.out.println(info.isBalance());
        Info info1 = recursiveTree.GetMaxSize(root);
        System.out.println(info1.getMaxDistance());

    }


    public Info TreeIsBalance(TreeNode root){
        if(root == null)
            return new Info(0,true);
        Info left = TreeIsBalance(root.getLeft());
        Info right = TreeIsBalance(root.getRight());
        boolean isBalance =true;
        if(!left.isBalance() || !right.isBalance() || Math.abs(right.getHeight()- left.getHeight()) > 1){
            isBalance =false;
        }
        int Height = Math.max(left.getHeight(),right.getHeight())+1;
        return new Info(Height,isBalance);
    }

    public Info GetMaxSize(TreeNode root){
        if(root ==null){
            return new Info(0,0);
        }
        Info left = GetMaxSize(root.getLeft());
        Info right =GetMaxSize(root.getRight());
        int height = Math.max(left.getHeight(), right.getHeight())+1;
        int maxDistance = Math.max(Math.max(left.getMaxDistance(),right.getMaxDistance()),
                left.getHeight()+ right.getHeight()+1);
        return new Info(height,maxDistance);
    }

}
class Info{
    private int height;
    private int maxDistance;
    private boolean isBalance;

    public Info(int height, int maxDistance) {
        this.height = height;
        this.maxDistance = maxDistance;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public Info(int height, boolean isBalance) {
        this.height = height;
        this.isBalance = isBalance;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isBalance() {
        return isBalance;
    }

    public void setBalance(boolean balance) {
        isBalance = balance;
    }
}
