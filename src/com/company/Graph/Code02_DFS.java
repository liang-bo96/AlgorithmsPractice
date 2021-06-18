package com.company.Graph;

import java.util.HashSet;
import java.util.Stack;

import static com.company.Graph.Code01_BFS.createTree;


public class Code02_DFS {
	public static void main(String[] args) {
		Node tree = createTree();
		dfs(tree);
	}
	static HashSet<Node> set = new HashSet<>();
	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		set.add(node);
		System.out.println(node.value);
			for (Node next : node.nexts) {
				if (!set.contains(next)) {
					dfs(next);
				}
			}
	}
//	public static void dfs2(Node start){
//		Stack<Node> stack = new Stack<Node>();
//		HashSet<Node> set = new HashSet<>();
//		stack.add(start);
//		set.add(start);
//		System.out.println(start.value);
//		while (!stack.isEmpty()){
//			Node pop = stack.pop();
//			System.out.println(pop.value);
//			for (Node next : pop.nexts){
//				if (!set.contains(next)){
//					stack.push(pop);
//					stack.push(next);
//					set.add(next);
//					System.out.println(next.value);
//					break;
//				}
//			}
//		}
//
//	}
	
	
	

}
