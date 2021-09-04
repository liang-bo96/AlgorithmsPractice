package com.Algorithm.UnionFind;

public class Edge<V> {
	public double weight;
	public Node<V> from;
	public Node<V> to;

	public Edge(double weight, Node<V> from, Node<V> to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}

}
