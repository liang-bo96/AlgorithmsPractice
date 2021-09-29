package com.Algorithm.Stack;

import java.util.Stack;

public class N155_MinStack {
    public static void main(String[] args) {
        N155_MinStack n155_minStack = new N155_MinStack();
        n155_minStack.push(0);
        n155_minStack.push(1);
        n155_minStack.push(0);
        System.out.println(n155_minStack.getMin());
        n155_minStack.pop();
        System.out.println(n155_minStack.top());
        System.out.println(n155_minStack.getMin());
    }
    static Stack<Integer> s;
    static Stack<Integer> min;
    /** initialize your data structure here. */
    public N155_MinStack() {
        s = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        s.push(val);
        if(min.isEmpty() || val <= min.peek()){
            min.push(val);
        }
    }

    public void pop() {
        int val = s.pop();
        if(val == min.peek()){
            min.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
