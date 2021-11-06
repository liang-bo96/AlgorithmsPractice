package com.Algorithm.Leetcode;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 */
public class N50_Pow {
    public static void main(String[] args) {
        System.out.println(new N50_Pow().myPow(2, 2));
    }
    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                //落单就乘到结果上
                res *= x;
            }
            //乘到底上
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }
}
