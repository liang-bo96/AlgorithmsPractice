package com.MiHaYou;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().test(9, 4));
    }
    public int test(int n,int step){
        return process(n,step,0);
    }
    public int process(int n, int step,int tem_location){
        if(step == 0){
            if(tem_location == 0){
                return 1;
            }else{
                return 0;
            }
        }
        if(tem_location == 0){
            int k = process(n,step -1,1) + process(n,step - 1,n);
            return k;
        }
        if(tem_location == n){
            int k =  process(n,step -1,0) + process(n,step - 1,n - 1);
            return k;
        }
        int k =  process(n,step -1,tem_location - 1) + process(n,step - 1,tem_location + 1);
        return k;
    }
}
