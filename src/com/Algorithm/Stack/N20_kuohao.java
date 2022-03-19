package com.Algorithm.Stack;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 */
public class N20_kuohao {
    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] tem = s.toCharArray();
        boolean flag = true;
        for (int i = 0; i < tem.length; i++) {
            if (tem[i] == ')') {
                flag = stack.pop() == '(';
                if (!flag) return false;
                break;
            }
            if (tem[i] == ']') {
                flag = stack.pop() == '[';
                if (!flag) return false;
                break;
            }
            if (tem[i] == '}') {
                flag = stack.pop() == '{';
                if (!flag) return false;
                break;
            }
            stack.push(tem[i]);
        }
        return stack.isEmpty();
    }

    //for practice
    public boolean isValid1(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ;i < array.length; i++){
            if(array[i] == '(' || array[i] == '[' || array[i] == '{'){
                stack.push(array[i]);
            }else if(array[i] == ')'){
                if(stack.isEmpty() ||stack.pop() != '('){
                    return false;
                }
            }
            else if(array[i] == ']'){
                if(stack.isEmpty() ||stack.pop() != '['){
                    return false;
                }
            }
            else if(array[i] == '}'){
                if(stack.isEmpty() ||stack.pop() != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
