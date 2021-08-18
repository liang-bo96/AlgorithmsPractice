package com.Algorithm.Graph;

import java.util.*;

public class Code01_BFS {

	// 从node出发，进行宽度优先遍历
	public static void bfs(Node start) {
		if (start == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> set = new HashSet<>();
		queue.add(start);
		set.add(start);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value);
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					set.add(next);
					queue.add(next);
				}
			}
		}
	}

	/**
	 * 练习
	 * @param
	 */

	public static void bfs1(Node start){
		Queue<Node> queue = new LinkedList<>();
		Set<Node> set = new HashSet<>();
		queue.add(start);
		set.add(start);
		while(!queue.isEmpty()){
			Node tem = queue.poll();
			System.out.println(tem.value);
			for(Node node : tem.nexts){
				if(!set.contains(node)){
					set.add(node);
					queue.add(node);
				}
			}
		}

	}




	public static void main(String[] args) {
		Node tree = createTree();
		bfs1(tree);
	}



	public static Node createTree(){
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);

		a.nexts.add(b);
		a.nexts.add(c);
		a.nexts.add(d);

		b.nexts.add(e);
		b.nexts.add(c);

		c.nexts.add(a);
		c.nexts.add(d);
		c.nexts.add(b);
		c.nexts.add(e);

		d.nexts.add(a);
		d.nexts.add(e);

		e.nexts.add(d);

		return a;
	}

}
