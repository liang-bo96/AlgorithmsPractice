package com.company.TargetingOffer;

public class N13 {
    public static void main(String[] args) {
        N13 n13 = new N13();
        System.out.println(n13.isBigger(35,37,18));
        System.out.println(n13.movingCount(3, 2, 17));
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
        return re <= k;
    }

    static int count;
    public int movingCount(int m, int n, int k) {
        boolean[][] tem = new boolean[m][n];
        dfs(0,0,m,n,k,tem);
        return count;
    }

    void dfs(int i, int j,int m, int n, int k,boolean[][] tem){
        if(i < 0 || j < 0 ||  i >= m || j >=n ){
            return;
        }
        if(!isBigger(i,j,k) || tem[i][j]){
            return;
        }
        tem[i][j] =true;
        count ++;
        dfs(i+1,j,m,n,k,tem);
        dfs(i,j+1,m,n,k,tem);
        dfs(i-1,j,m,n,k,tem);
        dfs(i,j-1,m,n,k,tem);
    }


}
