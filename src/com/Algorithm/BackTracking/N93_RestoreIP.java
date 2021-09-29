package com.Algorithm.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. ��ԭ IP ��ַ
 * ����һ��ֻ�������ֵ��ַ��������Ա�ʾһ�� IP ��ַ���������п��ܴ� s ��õ� ��Ч IP ��ַ ������԰��κ�˳�򷵻ش𰸡�
 *
 * ��Ч IP ��ַ �������ĸ�������ÿ������λ�� 0 �� 255 ֮����ɣ��Ҳ��ܺ���ǰ�� 0��������֮���� '.' �ָ���
 *
 * ���磺"0.1.2.201" �� "192.168.1.1" �� ��Ч IP ��ַ������ "0.011.255.245"��"192.168.1.312" �� "192.168@1.1" �� ��Ч IP ��ַ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺s = "25525511135"
 * �����["255.255.11.135","255.255.111.35"]
 * ʾ�� 2��
 *
 * ���룺s = "0000"
 * �����["0.0.0.0"]
 * ʾ�� 3��
 *
 * ���룺s = "1111"
 * �����["1.1.1.1"]
 * ʾ�� 4��
 *
 * ���룺s = "010010"
 * �����["0.10.0.10","0.100.1.0"]
 * ʾ�� 5��
 *
 * ���룺s = "101023"
 * �����["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
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
