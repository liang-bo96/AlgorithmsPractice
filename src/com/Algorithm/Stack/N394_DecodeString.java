package com.Algorithm.Stack;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;

/**
 * 394. �ַ�������
 * ����һ������������ַ������������������ַ�����
 * <p>
 * �������Ϊ: k[encoded_string]����ʾ���з������ڲ��� encoded_string �����ظ� k �Ρ�ע�� k ��֤Ϊ��������
 * <p>
 * �������Ϊ�����ַ���������Ч�ģ������ַ�����û�ж���Ŀո�������ķ��������Ƿ��ϸ�ʽҪ��ġ�
 * <p>
 * ���⣬�������Ϊԭʼ���ݲ��������֣����е�����ֻ��ʾ�ظ��Ĵ��� k �����粻������� 3a �� 2[4] �����롣
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "3[a]2[bc]"
 * �����"aaabcbc"
 * ʾ�� 2��
 * <p>
 * ���룺s = "3[a2[c]]"
 * �����"accaccacc"
 * ʾ�� 3��
 * <p>
 * ���룺s = "2[abc]3[cd]ef"
 * �����"abcabccdcdcdef"
 */
public class N394_DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString1("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        char[] c = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (c[i] < '9' && c[i] > '0') {
                int times = Integer.parseInt(String.valueOf(c[i]));
                for (int j = 0; j < times; j++) {
                    res.append(stack.peek());
                }
                stack.pop();
            } else if (c[i] == ']') {
                StringBuilder te = new StringBuilder();
                i--;
                while (c[i] != '[') {
                    te.append(c[i]);
                    i--;
                }
                stack.push(te.toString());
            } else {
                res.append(c[i]);
            }
        }
        return res.reverse().toString();
    }

    //reference
    public static String decodeString1(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                    res.append(c);
            }
        }
        return res.toString();
    }
//
//    ���ߣ�jyd
//    ���ӣ�https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
//    ��Դ�����ۣ�LeetCode��
//    ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
}
