package com.company.Graph;

import java.util.HashSet;
import java.util.Stack;

import static com.company.Graph.Code01_BFS.createTree;


public class Code02_DFS {
	public static void main(String[] args) {
		Node tree = createTree();
		dfs2(tree);
//		dfs(tree);
	}
//	static Stack<Node> stack = new Stack<>();
	static HashSet<Node> set = new HashSet<>();
	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
//		stack.add(node);
		set.add(node);
		System.out.println(node.value);
//		while (!stack.isEmpty()) {
//			Node cur = stack.pop();
			for (Node next : node.nexts) {
				if (!set.contains(next)) {
					dfs(next);
//					stack.push(node);
//					stack.push(next);
//					set.add(next);
//					System.out.println(next.value);
//					break;
				}
			}
//		}
//		for(int i = 0;i<5;i++){
//			System.out.println(stack.pop().value);
//		}
	}

	public static void dfs2(Node start){
		Stack<Node> stack = new Stack<Node>();
		HashSet<Node> set = new HashSet<>();
		stack.add(start);
		set.add(start);
		System.out.println(start.value);
		while (!stack.isEmpty()){
			Node pop = stack.pop();
//			System.out.println(pop.value);
			for (Node next : pop.nexts){
				if (!set.contains(next)){
					stack.push(pop);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}

	}
	
	
	

}
