package com.company.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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

	public static void bfs2(Node start){
		HashSet<Node> set = new HashSet<>();
		Queue<Node> list = new LinkedList<>();
		set.add(start);
		list.add(start);
		while (!list.isEmpty()){
			Node poll = list.poll();
			System.out.println(poll.value);
			for(Node node: poll.nexts){
				if(!set.contains(node)){
					set.add(node);
					list.add(node);
				}
			}
		}
	}



	public static void main(String[] args) {
		Node tree = createTree();
		bfs2(tree);
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
