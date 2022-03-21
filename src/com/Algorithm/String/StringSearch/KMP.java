package com.Algorithm.String.StringSearch;

public class KMP {
    public static void main(String[] args) {
        int possibilities = 5;
        int strSize = 20;
        int matchSize = 5;
        int testTimes = 500000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strSize);
            String match = getRandomString(possibilities, matchSize);
            if (search(str, match) != str.indexOf(match)) {
                System.out.println("Oops!");
                System.out.println(str);
                System.out.println(match);
                System.out.println(search(str, match));
                System.out.println(str.indexOf(match));
            }
        }
        System.out.println("test finish");
    }

    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }

    public static int search(String str,String match){
        if(str == null || match == null || str.length() == 0 || str.length() < match.length()){
            return -1;
        }
        char[] strarray = str.toCharArray();
        char[] matcharray = match.toCharArray();
        int[] nextarray = getNextarray(matcharray);
        int i = 0;
        int j = 0;
        while(i < strarray.length && j < matcharray.length){
            if(strarray[i] == matcharray[j]){
                i++;
                j++;
            }else if(j == 0){
                i++;
            }else{
                j = nextarray[j];
            }
        }
        return j == matcharray.length ? i - j : -1;
      }
      public static int[] getNextarray(char[] matcharray){
        if(matcharray.length == 1){
            return new int[]{-1};
        }
        int[] result = new int[matcharray.length];
        result[0] = -1;
        result[1] = 0;
        int i = 2;
        int tem = result[i-1];
        while(i < result.length){
            if(matcharray[i-1] == matcharray[tem]){
                result[i] = ++tem ;
                i++;
            }else if(tem == 0){
                result[i++] = 0;
            }else{
                tem = result[tem];
            }
        }
        return result;
      }
}
