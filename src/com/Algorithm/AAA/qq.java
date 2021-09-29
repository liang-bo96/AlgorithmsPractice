package com.Algorithm.AAA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class qq {
    public static void main(String[] args) {
        System.out.println(new qq().solution(new String[]{"X.....>","..v..X.",".>..X..","A......"}));
//        System.out.println(Integer.parseInt("123".substring(0,3))-11);
    }
    public String solution(String S){
        int len = S.length();
        char[] array = S.toCharArray();
        int  l = len /2;
        for (int i = 0; i < l; i++) {
            if(array[i] == '?' && array[len - i - 1] == '?'){
                array[i] = 'a';
                array[len - i - 1] = 'a';
            }else if(array[i] == '?' && array[len - i - 1] != '?'){
                array[i] = array[len - i - 1];
            }else if(array[i] != '?' && array[len - i - 1] == '?'){
                array[len - i - 1] = array[i];
            }else if(array[i] != array[len - i - 1]){
                return "NO";
            }
        }
        String s = new String(array);
        return s;
    }

    public static int  solution(int N,String S){
        String[] s = S.split(" ");
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(String tem : s){
            if(tem == null || tem.length() == 0){
                continue;
            }
            int num = 0;
            if(tem.length() == 2){
                num = Integer.parseInt(String.valueOf(tem.charAt(0)));
            }else if(tem.length() == 3){
                num = Integer.parseInt(tem.substring(0,2));
            }
            if(!map.containsKey(num)){
                map.put(num,new ArrayList<>());
            }
            map.get(num).add(tem.charAt(tem.length() - 1) - 'A');
        }
        int count = 0;
        for(int i : map.keySet()){
            List<Integer> list = map.get(i);
            count += help(list);
        }
        return count + (N - map.size()) * 2;
    }
    public static int help(List<Integer> l){
        int count = 0 ;
        int[] tem = new int[]{1,3,5};
        for(int i : tem){
            boolean flag = false;
            for (int j = 0; j < 4; j++) {
                if (l.contains(i + j)){
                    flag = true;
                }
            }
            if(!flag){
                count++;
                for (int j = 0; j < 4; j++) {
                    l.add(i+j);
                }
            }
        }
        return count;
    }

    public boolean solution(String[] B){
        int height = B.length;
        int width = B[0].length();
        char[][] arr= new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = B[i].charAt(j);
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                infect(arr,i,j);
            }
        }
        boolean flag = false;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean[][] visited = new boolean[height][width];
                if(arr[i][j] == 'A'){
                    flag = true;
                    dfs(arr,i,j,visited);
                }
            }
        }
        if(!flag){
            return false;
        }
        return arr[height-1][width - 1] == 'A';

    }
    public static void dfs(char[][]grid,int i,int j,boolean[][]visited){
        if(i < 0 || i >= grid.length || j <0 || j >= grid[0].length || grid[i][j] == 'X'|| visited[i][j]
                || grid[i][j] == '<'
                || grid[i][j] == '>'
                || grid[i][j] == 'v'
                || grid[i][j] == '^'
                || grid[i][j] == 'S'
        ){
            return;
        }
        grid[i][j] = 'A';
        visited[i][j] = true;
        dfs(grid,i - 1,j,visited);
        dfs(grid,i + 1,j,visited);
        dfs(grid,i,j - 1,visited);
        dfs(grid,i,j + 1,visited);
        visited[i][j] = false;
    }
    public static void infect(char[][]arr,int i, int j){
        if(arr[i][j] == 'X' || arr[i][j] =='.' ||arr[i][j] == 'A'){
            return;
        }
        char c = arr[i][j];
        if(c == '<'){
            while(j >= 0 && arr[i][j] != 'X'&& arr[i][j] != '>'&& arr[i][j] != 'v'&& arr[i][j] != '^'){
                arr[i][j] = 'S';
                j--;
            }
        }
        if(c == '>'){
            while(j < arr[0].length && arr[i][j] != 'X'&& arr[i][j] != '<'&& arr[i][j] != 'v'&& arr[i][j] != '^'){
                arr[i][j] = 'S';
                j++;
            }
        }
        if(c == '^'){
            while(i >= 0 && arr[i][j] != 'X'&& arr[i][j] != '>'&& arr[i][j] != 'v'&& arr[i][j] != '<'){
                arr[i][j] = 'S';
                i--;
            }
        }
        if(c == 'v'){
            while(i < arr.length && arr[i][j] != 'X'&& arr[i][j] != '>'&& arr[i][j] != '<'&& arr[i][j] != '^'){
                arr[i][j] = 'S';
                i++;
            }
        }

    }
}
