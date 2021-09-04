package com.Algorithm.UnionFind;

import java.util.HashMap;
import java.util.HashSet;

public class Graph<V> {
	public HashMap<V, Node<V>> nodes;
	public HashSet<Edge<V>> edges;
	
	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
