package com.Algorithm.AScanner;

import java.util.Scanner;

/**
 * ����a+b
 * ���������ӿ��Բ鿴��ȷ�Ĵ���
 * 1
 * https://ac.nowcoder.com/acm/contest/5657#question
 * <p>
 * ��������:
 * �����������������a,b(1 <= a, b <= 10^9),�������ݰ������顣
 * <p>
 * �������:
 * ���a+b�Ľ��
 * <p>
 * ��������1:
 * 1 5
 * 10 20
 * <p>
 * �������1:
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
    //ע��������������-----------------------long
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
