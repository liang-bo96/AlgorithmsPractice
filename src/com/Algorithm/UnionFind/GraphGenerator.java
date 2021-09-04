package com.Algorithm.UnionFind;



public class GraphGenerator {

	// matrix 所有的边
	// N*3 的矩阵
	// [weight, from节点上面的值，to节点上面的值]
	// 
	// [ 5 , 0 , 7]
	// [ 3 , 0,  1]
	// 
	public static <V> Graph<V> createGraph(V[][] matrix,double[] weights,double[] verse) {
		Graph<V> graph = new Graph<>();
		for (int i = 0; i < matrix.length; i++) {
			 // 拿到每一条边， matrix[i] 
			double weight = weights[i];
			double vers = verse[i];
			V from = matrix[i][0];
			V to = matrix[i][1];
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node<>(from));
			}
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node<>(to));
			}
			Node<V> fromNode =  graph.nodes.get(from);
			Node<V> toNode = graph.nodes.get(to);
			Edge<V> newEdge = new Edge<V>(weight, fromNode, toNode);
			Edge<V> verEdge = new Edge<V>(vers, toNode, fromNode);
			fromNode.nexts.add(toNode);
			toNode.nexts.add(fromNode);
			fromNode.out++;
			toNode.in++;
			fromNode.edges.add(newEdge);
			graph.edges.add(newEdge);
		}
		return graph;
	}

}
