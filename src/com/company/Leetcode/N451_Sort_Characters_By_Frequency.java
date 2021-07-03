package com.company.Leetcode;

import java.util.*;
/*451. 根据字符出现频率排序
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

示例 1:

输入:
"tree"

输出:
"eert"

解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:

输入:
"cccaaa"

输出:
"cccaaa"

解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
示例 3:

输入:
"Aabb"

输出:
"bbAa"

解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。*/
public class N451_Sort_Characters_By_Frequency {
    public static void main(String[] args) {
        System.out.println(new N451_Sort_Characters_By_Frequency().frequencySort("Aabbb"));
//        System.out.println('A' - 'a');
    }
    public String frequencySort(String s) {
        char[] array = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else{
                map.put(array[i],map.get(array[i]) + 1);
            }
        }
        PriorityQueue<Fre> queue =new PriorityQueue<>((Fre o1, Fre o2)-> {
                return o2.num - o1.num;
        });
//        map.forEach((k,v) ->queue.add(new Fre(k,v)));
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            queue.add(new Fre(entry.getKey(),entry.getValue()));
        }
        String result = "";
        while(!queue.isEmpty()){
            Fre poll = queue.poll();
            for (int i = 0; i < poll.num; i++) {
                result += poll.value;
            }
        }
        return result;
    }
}
class Fre{
    public char value;
    public int num;

    public Fre() {
    }

    public Fre(char value, int num) {
        this.value = value;
        this.num = num;
    }
}
