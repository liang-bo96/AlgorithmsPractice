package com.Algorithm.Redbag;

import java.util.*;

public class RedBag1 {
    public static void main(String[] args) {
        int totalAmount=1000;//�������
        int totalPeopleNum=5;//�������
        List<Integer> list=new ArrayList<Integer>();
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (list.size()<totalPeopleNum) {
            int i=random.nextInt(totalAmount)+1;//���1��Ǯ
            if(!set.contains(i)){//���ظ��и���ӵ�����
                list.add(i);
            }
            set.add(i);
        }
        Collections.sort(list);
        int[] result = new int[totalPeopleNum];
        int tmp = 0;
        int count = list.get(list.size() - 2);
        for(int i = 0; i < totalPeopleNum; i++){
            result[i] = list.get(i) - tmp;
            tmp = list.get(i);
        }
        result[result.length - 1] = totalAmount - count;
        System.out.println(Arrays.toString(result));
        int c = 0;
        for(int i : result){
            c += i;
        }
        System.out.println(c);
    }

}
