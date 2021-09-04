package com.Algorithm.UnionFind;

import java.util.*;

public class N399_EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        String[][] arr = new String[equations.size()][2];
        HashMap<String,Double> dismap = new HashMap<>();
        double[] versvalue = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            versvalue[i] = 1/values[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = equations.get(i).get(0);
            arr[i][1] = equations.get(i).get(1);
            dismap.put(arr[i][0] + arr[i][1],values[i]);
            dismap.put(arr[i][1] + arr[i][0],versvalue[i]);
        }
        Graph<String> graph = GraphGenerator.createGraph(arr, values,versvalue);
        double[] result = new double[queries.size()];
        int i = 0;
        for(List<String> query : queries){
            set = new HashSet<>();
            Node<String> from = graph.nodes.get(query.get(0));
            Node<String> to = graph.nodes.get(query.get(1));
            if(from == null || to == null){
                result[i] = -1;
                i++;
                continue;
            }
            result[i] = dfs(graph,from,to,dismap);
            i++;
            for(String s:graph.nodes.keySet()){
                graph.nodes.get(s).distance = Integer.MAX_VALUE;
            }
        }
        return result;
    }
    static Set<Node<String>> set;
    public static double dfs(Graph<String> graph,Node<String> from,Node<String> to,HashMap<String,Double> dismap){
        Queue<Node<String>> queue = new LinkedList<>();
        queue.add(from);
        set.add(from);
        from.distance = 362880;
        while(!queue.isEmpty()){
            Node<String> poll = queue.poll();
            for(Node<String> node : poll.nexts){
                if(node.distance > poll.distance/dismap.get(poll.value+node.value)){
                    node.distance = poll.distance/dismap.get(poll.value+node.value);
                }
                if(!set.contains(node)){
                    queue.add(node);
                    set.add(node);
                }
            }
        }
        return to.distance == Integer.MAX_VALUE ? -1 : from.distance/ to.distance;
    }
}
