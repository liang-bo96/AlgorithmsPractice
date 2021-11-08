package com.Algorithm.StringMultiply;
//字符串相乘
public class StringMultiply {
    public static void main(String[] args) {
        for(int i = 0; i <10000;i++){
            for(int j = 0 ; j < 10000;j++){
                if(!stringmultiply(String.valueOf(i),String.valueOf(j)).equals(String.valueOf(i *j))){
                    System.out.println(i);
                    System.out.println(j);
                    System.out.println(stringmultiply(String.valueOf(i),String.valueOf(j)));
                    System.out.println(String.valueOf(i *j));
                    System.out.println("wrong");
                }

            }
        }
        System.out.println("right");
    }
    public static String stringmultiply(String num1,String num2){
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1+ len2];
        for(int i = len2 - 1 ; i >=0 ; i-- ){
            for(int j = len1 - 1; j >=0 ; j--){
                int location = i + j + 1;
                int tem1 = num2.charAt(i) - '0';
                int tem2 = num1.charAt(j) - '0';
                int sum = tem1 * tem2 + result[location];
                result[location] = sum % 10 ;
                result[location - 1] += sum/10 ;
            }
        }
        String t = "";
        boolean flag = false;
        int i = 0;
        for (; i < result.length; i++) {
            if(result[i] != 0){
                break;
            }
        }
        for (int j = i; j < result.length; j++) {
            t += result[j];
        }
        return t.length() == 0 ? "0" : t;
    }
}
