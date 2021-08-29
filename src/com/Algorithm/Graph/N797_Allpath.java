package com.Algorithm.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N797_Allpath {
    public static void main(String[] args) {
        System.out.println(new N797_Allpath().allPathsSourceTarget(new int[][]{{4,3,1}, {3,2,4}, {}, {4},{}}));

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        set = new HashSet<>();
        result = new ArrayList<>();
        Graph g = buildgraph(graph);
        Node from_node = g.nodes.get(0);
        Node to_node = g.nodes.get(graph.length - 1);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(from_node.value);
        dfs(g, from_node, to_node, list);
        return result;
    }

    public static void dfs(Graph g, Node from, Node to, List<Integer> route) {
        if (from.value == to.value) {
            result.add(new ArrayList<>(route));
            return;
        }
        for (Node node : from.nexts) {
            if (!set.contains(node)) {
                route.add(node.value);
                dfs(g, node, to, route);
                route.remove(route.size() - 1);
            }
        }
        set.remove(from);
    }

    static Set<Node> set;
    static List<List<Integer>> result;

    public static Graph buildgraph(int[][] graph) {
        Graph demo = new Graph();
        for (int i = 0; i < graph.length; i++) {
            int[] to = graph[i];
            if (!demo.nodes.containsKey(i)) {
                demo.nodes.put(i, new Node(i));
            }
            if (to.length == 0) continue;
            for (int j : to) {
                if (!demo.nodes.containsKey(j)) {
                    demo.nodes.put(j, new Node(j));
                }
                Node from_node = demo.nodes.get(i);
                Node to_node = demo.nodes.get(j);
                Edge edge = new Edge(1, from_node, to_node);
                demo.edges.add(edge);
                from_node.out++;
                to_node.in++;
                from_node.edges.add(edge);
                from_node.nexts.add(to_node);
            }
        }
        return demo;
    }

}
