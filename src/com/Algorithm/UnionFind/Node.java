package com.Algorithm.UnionFind;

import java.util.ArrayList;

// 点结构的描述
public class Node<V> {
	public V value;
	public double distance = Integer.MAX_VALUE;
	public int in;
	public int out;
	public ArrayList<Node<V>> nexts;
	public ArrayList<Edge<V>> edges;

	public Node(V value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
