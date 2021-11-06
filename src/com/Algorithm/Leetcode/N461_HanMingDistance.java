package com.Algorithm.Leetcode;

/**
 * 求两个整数二进制表示后对应位置不一样的数量 -> 异或运算后1的个数
 * 按位与
 * a & b
 *
 * 按位或
 * a | b
 *
 * 按位异或
 * a ^ b
 *
 * 按位取反
 * ~a
 */
public class N461_HanMingDistance {
    public int hammingDistance(int x, int y) {
        //x ^ y表示异或
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
