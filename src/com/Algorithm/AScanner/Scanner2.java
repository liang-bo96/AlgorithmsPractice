package com.Algorithm.AScanner;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/5657/F
 * 来源：牛客网
 *
 * 计算一系列数的和
 * 打开以下链接可以查看正确的代码
 * https://ac.nowcoder.com/acm/contest/5657#question
 *
 *
 * 输入描述:
 * 输入数据有多组, 每行表示一组输入数据。
 * 每行的第一个整数为整数的个数n(1 <= n <= 100)。
 * 接下来n个正整数, 即需要求和的每个正整数。
 * 输出描述:
 * 每组数据输出求和的结果
 * 示例1
 * 输入
 * 复制
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 输出
 * 复制
 * 10
 * 15
 */
public class Scanner2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //hasNextLine 错误
        while(scan.hasNext()){
            int len = scan.nextInt();
            if(len == 0){
                break;
            }
            int count = 0;
            for(int i = 0; i < len; i++){
                count += scan.nextInt();
            }
            System.out.println(count);
        }
    }
}
