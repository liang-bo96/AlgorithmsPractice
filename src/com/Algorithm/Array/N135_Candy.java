package com.Algorithm.Array;

import java.util.Arrays;

/**
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2]
 * 输出：5
 * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * <p>
 * 输入：[1,2,2]
 * 输出：4
 * 解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class N135_Candy {
    public static void main(String[] args) {
        System.out.println(candy2(new int[]{1, 2, 3, 3, 3, 2, 1}));
    }

    public static int candy(int[] ratings) {
        int count = 0;
        int[] re = new int[ratings.length];
        Arrays.fill(re, 1);
        //左到右遍历，如果出现增大的分数，就将糖果数量加一
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                re[i] = re[i - 1] + 1;
            }
        }
        //右到左遍历，如果出现增大的分数，就将糖果数量加一
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                re[i] = Math.max(re[i + 1] + 1, re[i]);
            }
        }
        for (int i : re) {
            count += i;
        }
        return count;
    }

    public static int candy2(int[] ratings) {
        int[] arr = new int[ratings.length];
        Arrays.fill(arr, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1] && arr[i] <= arr[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && arr[i] <= arr[i + 1]) {
                arr[i] = arr[i + 1] + 1;
            }
        }
        int count = 0;
        for (int i : arr) {
            count += i;
        }
        return count;
    }
}
