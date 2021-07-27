package com.Algorithm.BackTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。


示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]


提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class N17_CombinationOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(new N17_CombinationOfPhoneNumber().letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new LinkedList<>();
        List<String>[] list = new List[8];
        list[0] = new LinkedList<String>(Arrays.asList("a", "b", "c"));
        list[1] = new LinkedList<String>(Arrays.asList("d", "e", "f"));
        list[2] = new LinkedList<String>(Arrays.asList("g", "h", "i"));
        list[3] = new LinkedList<String>(Arrays.asList("j", "k", "l"));
        list[4] = new LinkedList<String>(Arrays.asList("m", "n", "o"));
        list[5] = new LinkedList<String>(Arrays.asList("p", "q", "r","s"));
        list[6] = new LinkedList<String>(Arrays.asList("t", "u", "v"));
        list[7] = new LinkedList<String>(Arrays.asList("w", "x", "y","z"));
        result = new LinkedList<>();
        process(digits,0,list,"");
        return result;
    }
    static List<String> result;
    public static void process(String digits,int index,List<String>[] list,String path){
        if(index == digits.length()){
            result.add(path);
            return;
        }
        int tem_Num = Integer.parseInt(String.valueOf(digits.charAt(index)));
        for(String t : list[tem_Num -2]){
            process(digits, index + 1, list, path + t);
        }
    }
}
