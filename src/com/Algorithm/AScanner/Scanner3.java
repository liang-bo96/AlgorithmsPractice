package com.Algorithm.AScanner;

import java.util.Scanner;

/**
 * ���ӣ�https://ac.nowcoder.com/acm/contest/5657/G
 * ��Դ��ţ����
 *
 * ���������ж���, ÿ�б�ʾһ���������ݡ�
 *
 * ÿ�в�����n���������ո������(1 <= n <= 100)��
 * �������:
 * ÿ�����������͵Ľ��
 * ʾ��1
 * ����
 * ����
 * 1 2 3
 * 4 5
 * 0 0 0 0 0
 * ���
 * ����
 * 6
 * 9
 * 0
 */
public class Scanner3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String s = scan.nextLine();
            String[] re = s.split(" ");
            int count = 0;
            for(String num :re){
                count += Integer.parseInt(num);
            }
            System.out.println(count);
        }
    }
}
