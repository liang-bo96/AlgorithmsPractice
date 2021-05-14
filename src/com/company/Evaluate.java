package com.company;

import edu.princeton.cs.algs4.Stack;

public class Evaluate {
    public static void main(String[] args) {
        String evaluate = "( ( ( 4 * 2 ) + ( 1 + 3 ) ) * 2 )";
        String[] s = evaluate.split(" ");
        Stack<String> stack = new Stack<String>();

        for (String symbol: s
             ) {
            if(symbol.equals("(")){
                stack.push(symbol);
            }else if(symbol.equals("+")){
                stack.push(symbol);
            }else if(symbol.equals("-")){
                stack.push(symbol);
            }else if(symbol.equals("*")){
                stack.push(symbol);
            }else if(symbol.equals("/")){
                stack.push(symbol);
            }else if (symbol.equals(")")){
                int i = Integer.parseInt(stack.pop());
                String mid = stack.pop();
                int j = Integer.parseInt(stack.pop());
                if(mid.equals("+")){
                    int k = i+j;
                    stack.pop();
                    stack.push(k+"");
                }else if(mid.equals("-")){
                    stack.pop();
                    int k = i-j;
                    stack.push(k+"");
                }else if(mid.equals("*")){
                    stack.pop();
                    int k = i*j;
                    stack.push(k+"");
                }else if(mid.equals("/")){
                    int k = i/j;
                    stack.pop();
                    stack.push(k+"");
                }
            }else{
                stack.push(symbol);
            }
        }

        System.out.println(stack.pop());
    }
}
