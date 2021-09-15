package com.MiHaYou;

public class Main {
    public String cutString (String original, int count) {
        if(original == null || original.length() == 0 || count <= 0){
            return "";
        }
        String re = "";
        for(char c : original.toCharArray()){
            if(c< 40869 && c >= 19968){
                if(count >= 2){
                    re += c;
                    count -= 2;
                }else{
                    break;
                }
            }else{
                if(count >= 1){
                    re += c;
                    count--;
                }else{
                    break;
                }
            }
        }
        return re;



//        char[] array = original.toCharArray();
//        long i = 0;
//        while(count > 0){
//            if(i == array.length){
//                break;
//            }
//            if(array[(int) i]< 40869 && array[i] >= 19968){
//                if(count >= 2){
//                    re += array[i];
//                }else{
//                    break;
//                }
//                count -= 2;
//            }else{
//                re += array[i];
//                count--;
//            }
//            i++;
//        }
//        return re;
    }

    public static void main(String[] args) {
        System.out.println(new Main().cutString("¹þ£¡@#£¡@¹þ¹þ¹þ", 99));
    }
}
