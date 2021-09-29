package com.Algorithm.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 */
public class N415_Stringadd_36add {

    public static void main(String[] args) {
        System.out.println(new N415_Stringadd_36add().addStrings("9", "99"));
        System.out.println(new N415_Stringadd_36add().addStrings1("9", "0"));
        char[] array = "   123".toCharArray();
        System.out.println(array);
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        Collections.reverse(l);
        System.out.println(l);
    }
    //-------------------------------------reference------------------------------------------------
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                carry += num2.charAt(j) - '0';
                j--;
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    //practice
    public String addStrings1(String num1, String num2) {
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        int max = Math.max(s1.length, s2.length);
        int min = Math.min(s1.length, s2.length);
        if (max != min) {
            char[] ref = new char[max];
            Arrays.fill(ref, '0');
            if (s1.length > s2.length) {
                for (int i = 0; i < s2.length; i++) {
                    ref[i + max - min] = s2[i];
                }
            } else {
                for (int i = 0; i < s1.length; i++) {
                    ref[i + max - min] = s1[i];
                }
            }
            if (s1.length == ref.length) {
                s2 = ref;
            } else {
                s1 = ref;
            }
        }
        StringBuilder re = new StringBuilder();
        int k = 0;
        for (int i = max - 1; i >= 0; i--) {
            int t1 = Integer.parseInt(String.valueOf(s1[i])) + Integer.parseInt(String.valueOf(s2[i])) + k;
            re.append(t1 % 10);
            k = t1 / 10;
        }
        if (k != 0) {
            re.append(k);
        }
        return re.reverse().toString();
    }
}

