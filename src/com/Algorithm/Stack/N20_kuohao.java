package com.Algorithm.Stack;

import java.util.Stack;

/**
 * 20. ��Ч������
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ��� s ���ж��ַ����Ƿ���Ч��
 *
 * ��Ч�ַ��������㣺
 *
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 *
 *
 * ʾ�� 1��
 *
 * ���룺s = "()"
 * �����true
 * ʾ�� 2��
 *
 * ���룺s = "()[]{}"
 * �����true
 * ʾ�� 3��
 *
 * ���룺s = "(]"
 * �����false
 * ʾ�� 4��
 *
 * ���룺s = "([)]"
 * �����false
 * ʾ�� 5��
 *
 * ���룺s = "{[]}"
 * �����true
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
