package com.BiliBili;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static int result;
    public static void main(String[] args) {
        result = 0;
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> re = new ArrayList<>();
        while(sc.hasNextLine()){
            String[] strings = sc.nextLine().split(",");
            List<Integer> l = new ArrayList<>();
            for(String s : strings){
                int t = judge(s);
                l.add(t);
            }
            re.add(l);
        }
        int heigth = re.size();
        int width = re.get(0).size();
        int[][] arr =new int[re.size()][re.get(0).size()];
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = re.get(i).get(j);
            }
        }
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                boolean[][] visiter = new boolean[heigth][width];
                dfs(arr,i,j,visiter,0);
            }
        }
        System.out.println(result);
    }
    public static void dfs(int[][]arr,int i, int j,boolean[][]visiter,int count){
        if(i <0 || j <0 || i >= arr.length || j >= arr[0].length || visiter[i][j] || arr[i][j] == 0){
            return;
        }
        count ++;
        result = Math.max(result,count);
        visiter[i][j] = true;
        dfs(arr,i+1,j,visiter,count);
        dfs(arr,i-1,j,visiter,count);
        dfs(arr,i,j + 1,visiter,count);
        dfs(arr,i,j - 1,visiter,count);
        visiter[i][j] = false;

    }
    public static int judge(String s){
        char[] array = s.toCharArray();
        for(Character c : array){
            if(c == '1' || c == '0'){
                return Integer.parseInt(String.valueOf(c));
            }
        }
        return 0;
    }
}
