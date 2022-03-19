package com.Algorithm.Leetcode;

/**
 * 14. �����ǰ׺
 * ��дһ�������������ַ��������е������ǰ׺��
 *
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺strs = ["flower","flow","flight"]
 * �����"fl"
 * ʾ�� 2��
 *
 * ���룺strs = ["dog","racecar","car"]
 * �����""
 * ���ͣ����벻���ڹ���ǰ׺��
 */
public class N14_Longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        String re = "";
        for(int i = 0; i < strs[0].length(); i++){
            if(!judge(strs,i)){
                break;
            }
            re = strs[0].substring(0,i + 1);
        }
        return re;
    }
    public static boolean judge(String[] strs,int location){
        char tem = strs[0].charAt(location);
        for(String str : strs){
            if(location >= str.length() || str.charAt(location) != tem){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new N14_Longest_common_prefix().longestCommonPrefix(new String[]{"flower","flo","flower","flower"}));
    }
}
