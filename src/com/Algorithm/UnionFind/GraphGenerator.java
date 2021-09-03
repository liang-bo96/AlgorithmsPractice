package com.Algorithm.UnionFind;

import com.Algorithm.Graph.Edge;
import com.Algorithm.Graph.Graph;
import com.Algorithm.Graph.Node;

public class GraphGenerator {

	// matrix 所有的边
	// N*3 的矩阵
	// [weight, from节点上面的值，to节点上面的值]
	// 
	// [ 5 , 0 , 7]
	// [ 3 , 0,  1]
	// 
	public static com.Algorithm.Graph.Graph createGraph(int[][] matrix) {
		com.Algorithm.Graph.Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {
			 // 拿到每一条边， matrix[i] 
			int weight = matrix[i][0];
			int from = matrix[i][1];
			int to = matrix[i][2];
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new com.Algorithm.Graph.Node(from));
			}
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new com.Algorithm.Graph.Node(to));
			}
			com.Algorithm.Graph.Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			com.Algorithm.Graph.Edge newEdge = new Edge(weight, fromNode, toNode);
			fromNode.nexts.add(toNode);
			fromNode.out++;
			toNode.in++;
			fromNode.edges.add(newEdge);
			graph.edges.add(newEdge);
		}
		return graph;
	}

}
