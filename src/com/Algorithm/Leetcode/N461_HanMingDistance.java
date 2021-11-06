package com.Algorithm.Leetcode;

/**
 * ���������������Ʊ�ʾ���Ӧλ�ò�һ�������� -> ��������1�ĸ���
 * ��λ��
 * a & b
 *
 * ��λ��
 * a | b
 *
 * ��λ���
 * a ^ b
 *
 * ��λȡ��
 * ~a
 */
public class N461_HanMingDistance {
    public int hammingDistance(int x, int y) {
        //x ^ y��ʾ���
        return Integer.bitCount(x ^ y);
    }
    public int hammingDistance1(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }
}
