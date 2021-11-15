package com.Algorithm.PrefixTree;

import javax.swing.tree.TreeNode;
import java.util.TreeMap;

/**
 * 实现前缀树
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串?word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 */
public class N208_ImplementTree {
    TreeNode root;

    static class TreeNode {
        public TreeNode[] nexts = new TreeNode[26];
        public boolean isEnd;
    }

    /**
     * Initialize your data structure here.
     */
    public N208_ImplementTree() {
        root = new TreeNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TreeNode tem = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(tem.nexts[index] == null){
                tem.nexts[index] = new TreeNode();
            }
            tem = tem.nexts[index];
        }
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
    public boolean startsWith(String prefix) {
        return starts(prefix) != null;
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
