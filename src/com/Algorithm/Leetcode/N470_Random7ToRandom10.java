package com.Algorithm.Leetcode;

/**
 * 470. 用 Rand7() 实现 Rand10()
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *
 * 不要使用系统的 Math.random() 方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [7]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [8,4]
 * 示例 3:
 *
 * 输入: 3
 * 输出: [8,1,10]
 */
public class N470_Random7ToRandom10 {
    public int rand7(){
        return (int)(Math.random() * 7);
    }

    /**
     * 已知 rand_N() 可以等概率的生成[1, N]范围的随机数
     * 那么：
     * (rand_X() - 1) × Y + rand_Y() ==> 可以等概率的生成[1, X * Y]范围的随机数
     * 即实现了 rand_XY()
     */
    public int rand10() {
        int num = 41;
        while(num > 40){
            num = (rand7()-1) * 7 + rand7();
        }
        return num % 10 + 1;
    }
}
