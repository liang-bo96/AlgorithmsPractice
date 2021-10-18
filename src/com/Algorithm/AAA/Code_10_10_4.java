package com.Algorithm.AAA;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author : qizidog
 * @date : 2021-10-10 12:02
 * @description :
 * 字节跳动秋招第4题
 *
 * 有1,2...n, n个数字,其中有且仅有一个数字是中奖的,这个数字是等概率随机生成的。
 *  Alice和Bob进行一个游戏:
 * 两人轮流猜一个1到n的数字, Alice先猜。
 * 每完成一次猜测,主持会大声说出刚刚的数字是猜小了还是猜大了或者猜中了,若猜中则猜的人赢下游戏.
 * 假设两人都是聪明的理智的,而且都知道对方是聪明的,求Alice获胜的概率,请保留5位小数输出答案。
 *
 * 考试的时候写错了个地方 ac 0% 不知道现在改对没有
 **/

public class Code_10_10_4 {
    private static HashMap<Integer, Double> dp = new HashMap<>();

    public static void main(String[] args) {
        // System.out.println("hello");
        // Scanner sc = new Scanner(System.in);
        // int caseNum = sc.nextInt();
        // double ret = process(caseNum);
        // System.out.println(String.format("%.5f", ret));

        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " -> " + String.format("%.5f", process(i)));
        }
    }

    private static double process(int n) {
        // 1  1
        // 2  0.5
        // 3  1/3 + 2/3*0.5  先猜1或3
        // 4  1/4 + 3/4*(1-process(3))    1/4 + 3/4*(1/4*(1-process(1))+2/4*process(2))
        // 5
        // base case
        if (n == 0 || n == 1) {
            return 1;
        } else if (n == 2) {
            return 0.5;
        } else {
            Double dd = dp.get(n);
            if (dd != null) {
                return dd;
            }
        }

        double ret = 0;
        double num = n;
        for (double i = 1; i * 2 <= num+1; i++) {
            double right = 1 / num;  // 一次就猜中的概率
            double fault = (1 - 1 / num) * (
                    ((i - 1) / (num - 1)) * (1 - process((int) (i - 1)))
                  + ((num - i) / (num - 1)) * (1 - process((int) (num - i)))
            );
            double tmp = right + fault;
            ret = Math.max(ret, tmp);
        }
        dp.put(n, ret);
        return ret;
    }
}