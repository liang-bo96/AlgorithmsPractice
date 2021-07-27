package com.Algorithm.DuXiaoManTest;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tem = sc.next();
        if(tem.length() == 5){
            System.out.println("horse");
        }else{
            if(judge(tem,"cat","pig")){
                System.out.println("cat");
            }else{
                System.out.println("pig");
            }
        }
    }
    public static boolean judge(String re,String cat,String pig){
        int countcat = 0;
        int countpig = 0;
        char[] res = re.toCharArray();
        char[] cats = cat.toCharArray();
        char[] pigs = pig.toCharArray();
        for(int i = 0; i < cats.length;i++){
            if(res[i] == cats[i]){
                countcat++;
            }
        }
        for(int i = 0; i < pigs.length;i++){
            if(res[i] == pigs[i]){
                countpig++;
            }
        }
        return countcat > countpig;

    }
}
