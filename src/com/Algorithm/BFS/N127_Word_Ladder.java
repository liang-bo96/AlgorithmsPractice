package com.Algorithm.BFS;

import com.Algorithm.Graph.Edge;
import com.Algorithm.Graph.Graph;
import com.Algorithm.Graph.Node;

import java.util.*;

/*
* 127. 单词接龙
字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：

序列中第一个单词是 beginWord 。
序列中最后一个单词是 endWord 。
每次转换只能改变一个字母。
转换过程中的中间单词必须是字典 wordList 中的单词。
给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。


示例 1：

输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
输出：5
解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
示例 2：

输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
输出：0
解释：endWord "cog" 不在字典中，所以无法进行转换。


提示：

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord、endWord 和 wordList[i] 由小写英文字母组成
beginWord != endWord
wordList 中的所有字符串 互不相同*/
public class N127_Word_Ladder {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log","cog"));
        System.out.println(new N127_Word_Ladder().ladderLength("mmt", "cog", list));
    }
    static String[] wlist;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wlist = new String[wordList.size() + 1];
        wordList.add(beginWord);
        Graph graph = buildGraph(wordList);
        int begin = 0;
        int end = -1;
        for(int i = 0; i < wlist.length; i++){
            if(wlist[i].equals(beginWord)){
                begin = i;
            }
            if(wlist[i].equals(endWord)){
                end = i;
            }
        }
        //end = -1说明数组中未找到endword
        //get = null说明beginword没有与数组中任意一个单词有关联
        if(end == -1 ||graph.nodes.get(begin) == null) return 0;
        Node begin_node = graph.nodes.get(begin);
        begin_node.distance = 1;
        Node end_node = graph.nodes.get(end);
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(begin_node);
        set.add(begin_node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(Node tem : cur.nexts){
                if(tem.distance > cur.distance + 1){
                    tem.distance = cur.distance + 1;
                }
                if(!set.contains(tem)){
                    set.add(tem);
                    queue.add(tem);
                }
            }
        }
        //等于MAX说明权重始终未被修改，返回0
        return end_node.distance == Integer.MAX_VALUE ? 0 :end_node.distance ;
    }
    public static Graph buildGraph(List<String> wordList){
        Graph graph = new Graph();

        for (int i = 0; i < wordList.size(); i++) {
            wlist[i] = wordList.get(i);
        }
        for (int i = 0; i < wlist.length; i++) {
            for (int j = i + 1; j < wlist.length; j++) {
                if(diff(wlist[i],wlist[j])){
                    if(!graph.nodes.containsKey(i)){
                        graph.nodes.put(i,new Node(i));
                    }
                    if(!graph.nodes.containsKey(j)){
                        graph.nodes.put(j,new Node(j));
                    }
                    Node from = graph.nodes.get(i);
                    Node to = graph.nodes.get(j);
                    Edge edge = new Edge(1, from, to);
                    graph.edges.add(edge);
                    from.out++;
                    from.in++;
                    from.edges.add(edge);
                    from.nexts.add(to);
                    to.out++;
                    to.in++;
                    to.edges.add(edge);
                    to.nexts.add(from);
                }
            }
        }
        return graph;
    }

    public static boolean diff(String s1,String s2 ){
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }
}
