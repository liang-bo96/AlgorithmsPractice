package com.Algorithm.BackTracking;

import java.util.ArrayList;
import java.util.List;
/*### 一、子集

问题很简单，输入一个**不包含重复数字**的数组，要求算法输出这些数字的所有子集。

比如输入 `nums = [1,2,3]`，你的算法应输出 8 个子集，包含空集和本身，顺序可以不同：

[ [],[1],[2],[3],[1,3],[2,3],[1,2],[1,2,3] ]*/
public class Ziji {
    static char[] arr;
    static List<String> result;
    public static void main(String[] args) {
        result = new ArrayList<>();
        //求字符串的全部子集
        Ziji("abc");
        System.out.println(result);
    }
    public static void Ziji(String s) {
        arr = s.toCharArray();
        process("",0,s.length());
    }
    public static void process(String s,int tem,int len ){
        if(tem == len){
            result.add(s);
            return;
        }
        process(s,tem + 1,len);
        process(s+arr[tem],tem + 1,len);
    }
}
