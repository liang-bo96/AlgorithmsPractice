package com.Algorithm.PrefixTree;

import javax.swing.tree.TreeNode;
import java.util.TreeMap;

/**
 * ʵ��ǰ׺��
 * ����ʵ�� Trie �ࣺ
 * <p>
 * Trie() ��ʼ��ǰ׺������
 * void insert(String word) ��ǰ׺���в����ַ��� word ��
 * boolean search(String word) ����ַ��� word ��ǰ׺���У����� true�������ڼ���֮ǰ�Ѿ����룩�����򣬷��� false ��
 * boolean startsWith(String prefix) ���֮ǰ�Ѿ�������ַ���?word ��ǰ׺֮һΪ prefix ������ true �����򣬷��� false ��
 * ?
 * <p>
 * ʾ����
 * <p>
 * ����
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * ���
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
