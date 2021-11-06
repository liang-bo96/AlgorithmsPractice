package com.Algorithm.Leetcode;

/**
 * 50. Pow(x, n)
 * ʵ�� pow(x, n) �������� x �� n ���ݺ���������xn����
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺x = 2.00000, n = 10
 * �����1024.00000
 * ʾ�� 2��
 *
 * ���룺x = 2.10000, n = 3
 * �����9.26100
 */
public class N50_Pow {
    public static void main(String[] args) {
        System.out.println(new N50_Pow().myPow(2, 2));
    }
    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                //�䵥�ͳ˵������
                res *= x;
            }
            //�˵�����
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }
}
