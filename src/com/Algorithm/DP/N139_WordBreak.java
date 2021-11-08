package com.Algorithm.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class N139_WordBreak {
    public static void main(String[] args) {
        System.out.println(new N139_WordBreak().wordBreak11("leetcodeleet", Arrays.asList("leet", "code")));
        System.out.println("abcabc".indexOf("ca"));
    }

    // ----------错的----------s中单词的顺序不能与字典里的单词颠倒------------------
    static List<String> res;

    public boolean wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        process(s, 0, wordDict, "");
        return judge(s);
    }

    public static void process(String s, int location, List<String> wordDict, String tem) {
        if (tem.length() > s.length() || location == wordDict.size()) {
            return;
        }
        if (tem.length() == s.length()) {
            res.add(tem);
            return;
        }
        process(s, location + 1, wordDict, tem);
        process(s, location, wordDict, tem + wordDict.get(location));
    }

    public static boolean judge(String s) {
        for (String tem : res) {
            if (tem.equals(s)) {
                return true;
            }
        }
        return false;
    }

    //-----------------------------------reference-------------------------
    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() + 1];
        return dfs(s, 0, wordDict, visited);
    }

    private boolean dfs(String s, int start, List<String> wordDict, boolean[] visited) {
        //把所有的word拿过来试一下
        for (String word : wordDict) {
            int nextStart = start + word.length();
            //不符合要求的word跳过
            if (nextStart > s.length() || visited[nextStart]) {
                continue;
            }

            if (s.indexOf(word, start) == start) {//观察s里面有没有目前这个word
                //正好填满或者后续可以填满（把s分成左半部分已经填满和右侧继续递归部分）
                if (nextStart == s.length() || dfs(s, nextStart, wordDict, visited)) {
                    return true;
                }
                visited[nextStart] = true;
            }
        }
        //没有符合的就返回false
        return false;
    }

    //-----------------------------dp-------------------------------
    public boolean wordBreakdp(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        //true 代表能被触及到
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            //从i左侧扫描
            for (int j = 0; j < i; j++) {
                //j能被触及到 并且存在j-i的单词 -> i能被触及到
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static boolean wordBreak11(String s, List<String> wordDict) {
        boolean[] judge = new boolean[s.length() + 1];
        judge[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (String str : wordDict) {
                //从i向后扫描，看看是否能扫到最后一个位置
                if (judge[i]
                        && i + str.length() <= s.length()
                        && s.substring(i, i + str.length()).equals(str)) {
                    judge[i + str.length()] = true;
                }
            }
        }
        return judge[s.length()];

    }
}
