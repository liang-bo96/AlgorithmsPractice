package com.company.BFS;


public class TreeNode{
    public String value;
    public int val;
    public TreeNode left;
    public TreeNode right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "value='" + value + '\'' +
                ", val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreeNode(String value) {
        this.value = value;
    }

    public TreeNode() {
    }

    public TreeNode(String value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }



    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

