package com.Algorithm.PrefixTree;

import java.util.HashMap;

/**
 * 677. 键值映射
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 *
 * 示例：
 *
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 */
public class N677_MapSumPairs {
    public static void main(String[] args) {
        N677_MapSumPairs pairs = new N677_MapSumPairs();
        pairs.insert("apple",3);
        System.out.println(pairs.sum("ap"));
        pairs.insert("app",2);
        pairs.insert("apple",2);
        System.out.println(pairs.sum("ap"));
    }
    ImplementTree prefixTree;
    public N677_MapSumPairs() {
        prefixTree = new ImplementTree();
    }

    public void insert(String key, int val) {
        prefixTree.insert(key, val);
    }

    public int sum(String prefix) {
        return prefixTree.startsWith(prefix);
    }
}
class ImplementTree {
    HashMap<String,Integer> map;
    TreeNode root;

    static class TreeNode {
        public TreeNode[] nexts = new TreeNode[26];
        public boolean isEnd;
        public int count;
    }

    /**
     * Initialize your data structure here.
     */
    public ImplementTree() {
        map = new HashMap<>();
        root = new TreeNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word,int value) {
        int tem_value = value;
        if(map.get(word) != null){
            value = value - map.get(word);
        }
        map.put(word,tem_value);
        TreeNode tem = root;
        for (int i = 0; i < word.length(); i++) {
            tem.count += value;
            int index = word.charAt(i) - 'a';
            if(tem.nexts[index] == null){
                tem.nexts[index] = new TreeNode();
            }
            tem = tem.nexts[index];
        }
        tem.count += value;
        tem.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return starts(word)!= null && starts(word).isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public int startsWith(String prefix) {
        return starts(prefix) == null ? 0 : starts(prefix).count;
    }

    public TreeNode starts(String prefix) {
        TreeNode tem = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(tem.nexts[index] == null){
                return null;
            }
            tem = tem.nexts[index];
        }
        return tem;
    }
}
