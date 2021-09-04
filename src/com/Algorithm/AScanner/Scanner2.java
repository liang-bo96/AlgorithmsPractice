package com.Algorithm.AScanner;

import java.util.Scanner;

/**
 * ���ӣ�https://ac.nowcoder.com/acm/contest/5657/F
 * ��Դ��ţ����
 *
 * ����һϵ�����ĺ�
 * ���������ӿ��Բ鿴��ȷ�Ĵ���
 * https://ac.nowcoder.com/acm/contest/5657#question
 *
 *
 * ��������:
 * ���������ж���, ÿ�б�ʾһ���������ݡ�
 * ÿ�еĵ�һ������Ϊ�����ĸ���n(1 <= n <= 100)��
 * ������n��������, ����Ҫ��͵�ÿ����������
 * �������:
 * ÿ�����������͵Ľ��
 * ʾ��1
 * ����
 * ����
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * ���
 * ����
 * 10
 * 15
 */
public class Scanner2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //hasNextLine ����
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
