package com.Algorithm.BackTracking;

import java.util.ArrayList;
import java.util.List;


/**
 * 22. ��������
 * ���� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
 * <p>
 * ��Ч������������㣺�����ű�������ȷ��˳��պϡ�
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 3
 * �����["((()))","(()())","(())()","()(())","()()()"]
 * ʾ�� 2��
 * <p>
 * ���룺n = 1
 * �����["()"]
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
