package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static com.Algorithm.Tree.LevelTravel.buildNode;

public class SerAndUnserTree {
    public static Queue<String> SerilizableTree(TreeNode head){
        Queue<String>  ans = new LinkedList<>();
        if (head==null){
            ans.add(null);
        }else{
            Queue<TreeNode> s= new LinkedList<>();
            s.add(head);
            ans.add(head.getValue());
            while(!s.isEmpty()){
                TreeNode first = s.poll();
                if(first.getLeft() != null){
                    ans.add(first.getLeft().getValue());
                    s.add(first.getLeft());
                }else{
                    ans.add(null);
                }
                if(first.getRight() != null){
                    ans.add(first.getRight().getValue());
                    s.add(first.getRight());
                }else{
                    ans.add(null);
                }
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static TreeNode BuildSerlizableTree(Queue<String> ans){
        Queue<TreeNode> s = new LinkedList<>();
        String poll = ans.poll();
        TreeNode head = buildNode(poll);
        s.add(head);
        TreeNode node;
        while(!s.isEmpty()){
            node = s.poll();
            node.setLeft(buildNode(ans.poll()));
            node.setRight(buildNode(ans.poll()));
            if(node.getLeft() != null){
                s.add(node.getLeft());
            }
            if(node.getRight()!=null){
                s.add(node.getRight());
            }
        }
        return head;
    }
}
