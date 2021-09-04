package com.Algorithm.AScanner;

import java.util.Scanner;

/**
 * 计算a+b
 * 打开以下链接可以查看正确的代码
 * 1
 * https://ac.nowcoder.com/acm/contest/5657#question
 * <p>
 * 输入描述:
 * 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。
 * <p>
 * 输出描述:
 * 输出a+b的结果
 * <p>
 * 输入例子1:
 * 1 5
 * 10 20
 * <p>
 * 输出例子1:
 * 6
 * 30
 */
public class Scanner1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int fir = sc.nextInt();
            int second = sc.nextInt();
            System.out.println(fir + second);
        }
    }
    //注意输入整数类型-----------------------long
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String s = scan.nextLine();
            String[] s1 = s.split(" ");
            long count = 0;
            for(String ss : s1){
                count += Long.parseLong(ss);
            }
            System.out.println(count);
        }
    }
}
