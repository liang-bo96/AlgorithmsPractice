package com.company.Leetcode;

import java.util.Stack;

/*9. 回文数
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。



示例 1：

输入：x = 121
输出：true
示例 2：

输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3：

输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。
示例 4：

输入：x = -101
输出：false


提示：

-231 <= x <= 231 - 1
*/
public class N9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        String tem = String.valueOf(x);
        char[] array = tem.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char i : array) {
            stack.push(i);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x / 10 != 0)) {
            return false;
        }
        int Res = 0;
        while (x > Res) {
            Res = Res * 10 + x % 10;
            x /= 10;
        }
        return x == Res || x == Res / 10;
    }
}
