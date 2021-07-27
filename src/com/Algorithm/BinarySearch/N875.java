package com.Algorithm.BinarySearch;

/*
* 875. 爱吃香蕉的珂珂
珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。

珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。

珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。

返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。



示例 1：

输入: piles = [3,6,7,11], H = 8
输出: 4
示例 2：

输入: piles = [30,11,23,4,20], H = 5
输出: 30
示例 3：

输入: piles = [30,11,23,4,20], H = 6
输出: 23*/
public class N875 {
    public static void main(String[] args) {
        System.out.println(
                new N875().minEatingSpeed(
                        new int[]{
                                332484035,524908576,855865114,632922376,222257295,
                                690155293,112677673,679580077,337406589,290818316,
                                877337160,901728858,679284947,688210097,692137887,
                                718203285,629455728,941802184},

        823855818));
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = getmax(piles);
        while(left <= right){
            int mid = left + (right - left) /2;
            if(fit(piles,mid,h)){
                right = mid - 1;
            }else if(!fit(piles,mid,h)){
                left = mid + 1;
            }
        }
        return left;
    }
    public static boolean fit(int[] piles, int t,int h){
        long count = 0;
        for(int tem : piles){
            count += (int)Math.ceil((double)tem/(double) t);
        }
        return count <= h;
    }
    public static int getmax(int[] p){
        int max = 0;
        for(int t : p){
            if(t > max){
                max = t;
            }
        }
        return max;
    }
}
