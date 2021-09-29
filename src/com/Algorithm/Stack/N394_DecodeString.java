package com.Algorithm.Stack;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
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
//    作者：jyd
//    链接：https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
