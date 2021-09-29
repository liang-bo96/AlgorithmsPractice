package com.Algorithm.Leetcode;

/**
 * 459. �ظ������ַ���
 * ����һ���ǿյ��ַ������ж����Ƿ����������һ���Ӵ��ظ���ι��ɡ��������ַ���ֻ����СдӢ����ĸ�����ҳ��Ȳ�����10000��
 *
 * ʾ�� 1:
 *
 * ����: "abab"
 *
 * ���: True
 *
 * ����: �������ַ��� "ab" �ظ����ι��ɡ�
 * ʾ�� 2:
 *
 * ����: "aba"
 *
 * ���: False
 * ʾ�� 3:
 *
 * ����: "abcabcabcabc"
 *
 * ���: True
 *
 * ����: �������ַ��� "abc" �ظ��Ĵι��ɡ� (�������ַ��� "abcabc" �ظ����ι��ɡ�)
 */
public class N459_RepeatSubString {
    public static void main(String[] args) {
        System.out.println(new N459_RepeatSubString().repeatedSubstringPattern("aabaaba"));
    }
    //���������µĻ����Ӵ������ܴ���ǰ׺��Ȼ�����αȽ��ܴ����Ӵ���Ӧλ���Ƿ����
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        if(s.length() == 1){
            return false;
        }
        for (int i = 1; i <= s.length() / 2; i++) {
            String tem = s.substring(0,i );
            if(s.length() % tem.length() == 0){
                boolean flag = true;
                for (int j = 0; j < s.length(); j++) {
                    if(s.charAt(j) != tem.charAt(j % tem.length())){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

        //����-��ʱ
    public boolean repeatedSubstringPattern1(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        if(s.length() == 1){
            return false;
        }
        for(int i = 0; i <= s.length(); i++){
            for (int j = i + 1; j < s.length(); j++) {
                if(judge(s,s.substring(i,j))){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean judge(String s1, String s2){
        int n = s1.length()/ s2.length();
        if(n < 1){
            return false;
        }
        String tem = "";
        for (int i = 0; i < n; i++) {
            tem += s2;
        }
        if(tem.equals(s1)){
            return true;
        }
        return false;
    }
}
