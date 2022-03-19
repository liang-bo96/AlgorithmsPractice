package com.Algorithm.UnionFind;

import java.util.*;

/**
 * 399. ������ֵ
 * ����һ������������ equations ��һ��ʵ��ֵ���� values ��Ϊ��֪���������� equations[i] = [Ai, Bi] �� values[i] ��ͬ��ʾ��ʽ Ai / Bi = values[i] ��ÿ�� Ai �� Bi ��һ����ʾ�����������ַ�����
 *
 * ����һЩ������ queries ��ʾ�����⣬���� queries[j] = [Cj, Dj] ��ʾ�� j �����⣬���������֪�����ҳ� Cj / Dj = ? �Ľ����Ϊ�𰸡�
 *
 * ���� ��������Ĵ� ���������ĳ���޷�ȷ���Ĵ𰸣����� -1.0 �������𰸡���������г����˸�������֪������û�г��ֵ��ַ�����Ҳ��Ҫ�� -1.0 �������𰸡�
 *
 * ע�⣺����������Ч�ġ�����Լ�����������в�����ֳ���Ϊ 0 ��������Ҳ������κ�ì�ܵĽ����
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * �����[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * ���ͣ�
 * ������a / b = 2.0, b / c = 3.0
 * ���⣺a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * �����[6.0, 0.5, -1.0, 1.0, -1.0 ]
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
