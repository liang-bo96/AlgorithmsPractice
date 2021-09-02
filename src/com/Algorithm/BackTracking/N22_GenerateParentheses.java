package com.Algorithm.BackTracking;

import java.util.ArrayList;
import java.util.List;


/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 */
public class N22_GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new N22_GenerateParentheses().generateParenthesis(20));
    }

    static List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        process(0, n * 2, "");
        return result;
    }

    public static void process(int location, int n, String temp) {
        if (location == n) {
            if (judge(temp)) {
                result.add(temp);
            }
            return;
        }
        process(location + 1, n, temp + "(");
        process(location + 1, n, temp + ")");
    }

    public static boolean judge(String s) {
        char[] array = s.toCharArray();
        int result = 0;
        for (char c : array) {
            if (c == '(') {
                result++;
            } else {
                result--;
            }
            if (result < 0) {
                return false;
            }
        }
        return result == 0;
    }
}
