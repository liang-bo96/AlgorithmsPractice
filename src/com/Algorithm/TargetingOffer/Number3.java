package com.Algorithm.TargetingOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Number3 {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        StringBuffer stringBuffer = new StringBuffer(" 1");
        stringBuffer.append("  ");
//        System.out.println(stringBuffer);
//        System.out.println(stringBuffer.charAt(0));
//        System.out.println(3/2);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        System.out.println(integers);
        integers.removeAll(integers);
        System.out.println(integers);
        integers.add(1);
        System.out.println(integers);
        int[] s = new int[]{1,3,5};
        int[] ints = Arrays.copyOfRange(s, 1, 2);
//        System.out.println(ints);
        System.out.println(1%2);
//        exchange(s);
        HashMap<String,Integer> h = new HashMap<>();
        h.put("a",1);

        h.put("a", 3);
        System.out.println(h.get("a")+"-----");

    }
    public static int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            while(nums[i]%2 !=0){i++;}
            while(nums[j]%2 == 0){j--;}
            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else{
                break;
            }

        }
        return nums;
    }
}
