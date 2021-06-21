package com.company.BackTracking;

public class HannoTpwer {
    public static void main(String[] args) {
        new HannoTpwer().transfer(3,"T1","T2","T3");
    }
    public static void transfer(int n,String from,String help,String to){
        if(n == 0) return;
        transfer(n-1,from,to,help);
        System.out.println("transfer " + n + from  + to);
        transfer(n-1,help,from,to);
    }
}
