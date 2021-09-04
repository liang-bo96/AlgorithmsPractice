package com.Algorithm.AScanner;

import java.util.*;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/5657/I
 * 来源：牛客网
 *
 * a c bb
 * f dddd
 * nowcoder
 * 输出
 * 复制
 * a bb c
 * dddd f
 * nowcoder
 */
public class Scanner4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String s = scan.nextLine();
            String[] s1 = s.split(" ");
            Arrays.sort(s1);
            for(int i = 0; i < s1.length - 1; i++){
                System.out.print(s1[i] + " ");
            }
            System.out.println(s1[s1.length - 1]);
        }
    }
}
