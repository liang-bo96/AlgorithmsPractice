package com.Algorithm.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 139. ���ʲ��
 * ����һ���ǿ��ַ��� s ��һ�������ǿյ��ʵ��б� wordDict���ж� s �Ƿ���Ա��ո���Ϊһ���������ֵ��г��ֵĵ��ʡ�
 * <p>
 * ˵����
 * <p>
 * ���ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
 * ����Լ����ֵ���û���ظ��ĵ��ʡ�
 * ʾ�� 1��
 * <p>
 * ����: s = "leetcode", wordDict = ["leet", "code"]
 * ���: true
 * ����: ���� true ��Ϊ "leetcode" ���Ա���ֳ� "leet code"��
 * ʾ�� 2��
 * <p>
 * ����: s = "applepenapple", wordDict = ["apple", "pen"]
 * ���: true
 * ����: ���� true ��Ϊ "applepenapple" ���Ա���ֳ� "apple pen apple"��
 * ע��������ظ�ʹ���ֵ��еĵ��ʡ�
 * ʾ�� 3��
 * <p>
 * ����: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * ���: false
 */
public class N139_WordBreak {
    public static void main(String[] args) {
        System.out.println(new N139_WordBreak().wordBreak11("leetcodeleet", Arrays.asList("leet", "code")));
        System.out.println("abcabc".indexOf("ca"));
    }

    // ----------���----------s�е��ʵ�˳�������ֵ���ĵ��ʵߵ�------------------
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
        //�����е�word�ù�����һ��
        for (String word : wordDict) {
            int nextStart = start + word.length();
            //������Ҫ���word����
            if (nextStart > s.length() || visited[nextStart]) {
                continue;
            }

            if (s.indexOf(word, start) == start) {//�۲�s������û��Ŀǰ���word
                //�����������ߺ���������������s�ֳ���벿���Ѿ��������Ҳ�����ݹ鲿�֣�
                if (nextStart == s.length() || dfs(s, nextStart, wordDict, visited)) {
                    return true;
                }
                visited[nextStart] = true;
            }
        }
        //û�з��ϵľͷ���false
        return false;
    }

    //-----------------------------dp-------------------------------
    public boolean wordBreakdp(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        //true �����ܱ�������
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            //��i���ɨ��
            for (int j = 0; j < i; j++) {
                //j�ܱ������� ���Ҵ���j-i�ĵ��� -> i�ܱ�������
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
                //��i���ɨ�裬�����Ƿ���ɨ�����һ��λ��
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
