package com.company.DP;
/*
* 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
 

示例 1：

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2：

输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
 

提示：

0 <= word1.length, word2.length <= 500
word1 和 word2 由小写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/edit-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class N72BianJiJuLi {
    public static void main(String[] args) {
        System.out.println(new N72BianJiJuLi().minDistance("dizine","aczine"));
        int[][] dp = new int[10][10];
        System.out.println(new N72BianJiJuLi().minDistance2("dizine","aczine",dp));
    }

    public int minDistance2(String word1, String word2,int[][] dp){

        int i = word1.length()-1;
        int j = word2.length()-1;
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        if(i == 0) {
            dp[i][j] = j;
            return dp[i][j];
        }
        if(j == 0) {
            dp[i][j] = i;
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = minDistance2(word1.substring(0,i),word2.substring(0,j),dp);
            return dp[i][j];
        }
        else{
            dp[i][j] = 1+Math.min(minDistance2(word1,word2.substring(0,j),dp)
                    ,Math.min(minDistance2(word1.substring(0,i),word2,dp),
                            minDistance2(word1.substring(0,i),word2.substring(0,j),dp)));
            return dp[i][j];
        }
    }


    public int minDistance(String word1, String word2) {
        if(word1.length() == 0 || word2.length()==0){
            return word1.length()== 0 ? word2.length() : word1.length();
        }
        if(word1.charAt(0) == word2.charAt(0)){
            return minDistance(word1.substring(1),word2.substring(1));
        }
        else{
            return 1+Math.min(minDistance(word1,word2.substring(1))
                    ,Math.min(minDistance(word1.substring(1),word2),
                            minDistance(word1.substring(1),word2.substring(1))));
        }
    }
}
