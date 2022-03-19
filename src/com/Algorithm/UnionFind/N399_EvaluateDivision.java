package com.Algorithm.UnionFind;

import java.util.*;

/**
 * 399. 除法求值
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 */
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
            result[i] = bfs(graph,from,to,dismap);
            i++;
            for(String s:graph.nodes.keySet()){
                graph.nodes.get(s).distance = Integer.MAX_VALUE;
            }
        }
        return result;
    }
    static Set<Node<String>> set;
    public static double bfs(Graph<String> graph,Node<String> from,Node<String> to,HashMap<String,Double> dismap){
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
