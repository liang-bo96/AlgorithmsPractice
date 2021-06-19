package com.company.Tree;

//import edu.princeton.cs.algs4.Queue;

import com.company.BFS.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import static com.company.Tree.SerAndUnserTree.BuildSerlizableTree;
import static com.company.Tree.SerAndUnserTree.SerilizableTree;

public class LevelTravel {
    public static  Queue<TreeNode> queue = new LinkedList<>();
    public static void main(String[] args) {
        RecursiveTravel recursiveTravel = new RecursiveTravel();
        TreeNode tree = recursiveTravel.createTree();
        queue.add(tree);
        levelTravel(tree);
        GetmaxWidth(tree);
        GetMaxWidth2(tree);
//        Queue<String> strings = PreTravelTree(tree);
//        TreeNode treeNode = BuildPreTravelTree(strings);
//        PreTravelTree(treeNode);
        Queue<String> strings1 = SerilizableTree(tree);
//        TreeNode treeNode1 = BuildSerlizableTree(strings1);
//        SerilizableTree(treeNode1);
    }
//    public static void levelTravel(TreeNode a){
//        while (!queue.isEmpty()){
//            if (a.getLeft()!=null){
//                queue.enqueue(a.getLeft());
//            }
//            if (a.getRight()!=null){
//                queue.enqueue(a.getRight());
//            }
//            if (a.getValue().equals("a")){
//                System.out.println(queue.dequeue());
//            }
//            TreeNode dequeue = queue.dequeue();
//            System.out.println(dequeue);
//            levelTravel(dequeue);
//        }
//
//    }
    public static void levelTravel(TreeNode a) {
        if (a == null) return;

        while(!queue.isEmpty()){
            TreeNode dequeue = queue.poll();
            if (dequeue.getLeft()!= null){
                queue.add(dequeue.getLeft());
            }
            if (dequeue.getRight()!=null){
                queue.add(dequeue.getRight());
            }
            System.out.println(dequeue);
        }
    }

    public static void GetmaxWidth(TreeNode a){
        Queue<TreeNode> s = new LinkedList<>();
        HashMap<TreeNode,Integer> map = new HashMap<>();
        s.add(a);
        int max = 0;
        int TreeNodeLevel = 1;
        int TreeLevelNodes = 0;
//        s.add(a);
        map.put(a,TreeNodeLevel);
        while(!s.isEmpty()){
            TreeNode head = s.poll();
            int curLevel = map.get(head);
            if(head.getLeft()!=null){
                s.add(head.getLeft());
                map.put(head.getLeft(),curLevel+1);
            }
            if(head.getRight()!=null){
                s.add(head.getRight());
                map.put(head.getRight(),curLevel+1);
            }
            if(TreeNodeLevel == curLevel){
                TreeLevelNodes++;
            }else{
                max = Math.max(max,TreeLevelNodes);
                TreeNodeLevel++;
                TreeLevelNodes=1;
            }
        }
        max = Math.max(max,TreeLevelNodes);
        System.out.println(max);
    }

    public static void GetMaxWidth2(TreeNode head){
        Queue<TreeNode> s = new LinkedList<>();
        TreeNode curEnd = head;
        TreeNode NextEnd = null;
        int CurLevelNodes = 0;
        int max = 0;
        s.add(head);
        while(!s.isEmpty()){
            TreeNode t = s.poll();
            if(t.getLeft() != null){
                s.add(t.getLeft());
                NextEnd = t.getLeft();
            }
            if(t.getRight()!=null){
                s.add(t.getRight());
                NextEnd = t.getRight();
            }
            CurLevelNodes++;
            if(t==curEnd){
                max = Math.max(max,CurLevelNodes);
                CurLevelNodes = 0;
                curEnd = NextEnd;
            }
        }
        System.out.println(max);
    }

    public static  Queue<String> PreTravelTree(TreeNode head){
        Queue<String> s = new LinkedList<>();
        Queue<String> strings = preTravelTree(head, s);
        System.out.println(s);
        return strings;
    }

    private static Queue<String>  preTravelTree(TreeNode head, Queue<String> s) {
        if(head==null){
            s.add(null);
        }else{
            s.add(head.getValue());
            preTravelTree(head.getLeft(),s);
            preTravelTree(head.getRight(),s);
        }
        return s;
    }

    public static TreeNode BuildPreTravelTree(Queue<String> s){
        String poll = s.poll();
        if (poll==null){
            return null;
        }
        TreeNode head = new TreeNode(poll);
        head.setLeft(BuildPreTravelTree(s));
//        head.setValue(poll);
        head.setRight(BuildPreTravelTree(s));
        return head;
    }



    public static TreeNode buildNode(String s){
        if (s == null){
            return null;
        }
        else{
            return new TreeNode(s);
        }
    }
    public static TreeNode buildNode(int s){
            return new TreeNode(s);

    }


}

