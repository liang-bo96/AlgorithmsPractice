package com.Algorithm.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class N93_RestoreIP {
    static List<String> result;
    public static List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        if(s.length() > 12){
            return result;
        }
        process(s,0,"",3);
        return result;
    }

    public static void process(String s,int location,String tem,int count){
        if(location == s.length()){
            if(!judge(tem)){
                return;
            }
            if (count == 0){
                result.add(tem);
            }
            return;
        }

        process(s,location + 1,tem + s.charAt(location),count);
        process(s,location + 1,tem + "." +s.charAt(location),--count);
    }

    public static boolean judge(String s){
        String[] split = s.split("\\.");
        if(split.length > 4){
            return false;
        }
        for(String tem : split){
            if(tem.length() == 0 ||tem.length() > 1 && tem.charAt(0) == '0'){
                return false;
            }
            if(Long.parseLong(tem) > 255 || Long.parseLong(tem) < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
