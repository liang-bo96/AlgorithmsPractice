package com.company.Leetcode;

public class N130 {
    public static void main(String[] args) {

    }
    public void solve(char[][] board) {
        int height = board.length;
        int width = board[0].length;
        for(int i = 0 ;i < width ; i++){
            if(board[0][i] == 'O'){
                dfs(board,0,i,'#');
            }
            if(board[height - 1][i] == 'O'){
                dfs(board,height - 1,i,'#');
            }
            if(board[i][0] == 'O'){
                dfs(board,i,0,'#');
            }
            if(board[i][width - 1] == 'O'){
                dfs(board,i,width - 1,'#');
            }
        }
        for(int i = 0 ; i < width;i++){
            for(int j = 0 ; j < height;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for(int i = 0 ;i < width ; i++){
            if(board[0][i] == '#'){
                dfs(board,0,i,'O');
            }
            if(board[height - 1][i] == '#'){
                dfs(board,height - 1,i,'O');
            }
            if(board[i][0] == '#'){
                dfs(board,i,0,'O');
            }
            if(board[i][width - 1] == '#'){
                dfs(board,i,width - 1,'O');
            }
        }

    }

    public static void dfs(char[][] board,int ){

    }
}
