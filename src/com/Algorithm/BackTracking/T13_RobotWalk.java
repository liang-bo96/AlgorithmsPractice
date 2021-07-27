package com.Algorithm.BackTracking;
/*剑指 Offer 13. 机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
请问该机器人能够到达多少个格子？

示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20*/
public class T13_RobotWalk {
    public static void main(String[] args) {
        System.out.println(new T13_RobotWalk().movingCount(2, 3, 17));
    }
    static int count;
    public int movingCount(int m, int n, int k) {
        count = 0;
        boolean[][] tem = new boolean[m][n];
        dfs(0,0,m,n,k,tem);
        return count;
    }

    void dfs(int i, int j,int m, int n, int k,boolean[][] tem){
        if(i < 0 || j < 0 ||  i >= m || j >=n ){
            return;
        }
        if(isBigger(i,j,k) || tem[i][j]){
            return;
        }
        tem[i][j] =true;
        count ++;
        dfs(i+1,j,m,n,k,tem);
        dfs(i,j+1,m,n,k,tem);
        dfs(i-1,j,m,n,k,tem);
        dfs(i,j-1,m,n,k,tem);
    }



    boolean isBigger(int m, int n, int k){
        int re = 0;
        while(m != 0){
            re += m % 10;
            m = m/10;
        }
        while(n != 0){
            re += n % 10;
            n = n/10;
        }
        return re > k;
    }
}
