package com.Algorithm.SlidingWindow;

import java.util.*;

/**
 * 30. �������е��ʵ��Ӵ�
 * ����һ���ַ��� s ��һЩ ������ͬ �ĵ��� words ���ҳ� s ��ǡ�ÿ����� words �����е��ʴ����γɵ��Ӵ�����ʼλ�á�
 * <p>
 * ע���Ӵ�Ҫ�� words �еĵ�����ȫƥ�䣬�м䲻���������ַ� ��������Ҫ���� words �е��ʴ�����˳��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "barfoothefoobarman", words = ["foo","bar"]
 * �����[0,9]
 * ���ͣ�
 * ������ 0 �� 9 ��ʼ���Ӵ��ֱ��� "barfoo" �� "foobar" ��
 * �����˳����Ҫ, [9,0] Ҳ����Ч�𰸡�
 * ʾ�� 2��
 * <p>
 * ���룺s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * �����[]
 * ʾ�� 3��
 * <p>
 * ���룺s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * �����[6,9,12]
 */
public class N30_Containallsubstring {

    //reference
    public static List<Integer> solution2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        if (s.length() == 0 || words.length == 0) return res;
        for (String word: words) {
            // ����s��û��������ʣ�ֱ�ӷ��ؿ�
            if (s.indexOf(word) < 0) return res;
            // map�б���ÿ�����ʣ��������ֵĴ���
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        // ÿ�����ʵĳ��ȣ� �ܳ���
        int oneLen = words[0].length(), wordsLen = oneLen * words.length;
        // ����s����С�ڵ����ܺͣ����ؿ�
        if (wordsLen > s.length()) return res;
        // ֻ���۴�0��1��...�� oneLen-1 ��ʼ���Ӵ������
        // ÿ�ν���ƥ��Ĵ��ڴ�СΪ wordsLen��ÿ�κ���һ�����ʳ��ȣ������Ҵ���ά�ֵ�ǰ����λ��
        for (int i = 0; i < oneLen; ++i) {
            // ���Ҵ���
            int left = i, right = i, count = 0;
            // ͳ��ÿ������Ҫ���word
            Map<String, Integer> subMap = new HashMap<>();
            // �Ҵ��ڲ��ܳ�����������
            while (right + oneLen <= s.length()) {
                // �õ�һ������
                String word = s.substring(right, right + oneLen);
                // �д�������
                right += oneLen;
                // words[]��û��������ʣ���ô��ǰ���ڿ϶�ƥ��ʧ�ܣ�ֱ�����Ƶ�������ʺ���
                if (!wordsMap.containsKey(word)) {
                    left = right;
                    // �����ڵ���ͳ��map��գ�����ͳ��
                    subMap.clear();
                    // ����Ҫ��ĵ�������0
                    count = 0;
                } else {
                    // ͳ�Ƶ�ǰ�Ӵ���������ʳ��ֵĴ���
                    subMap.put(word, subMap.getOrDefault(word, 0) + 1);
                    ++count;
                    // ���������ʳ��ֵĴ�������words[]������Ӧ�Ĵ�����������ÿ��ƥ���words������ȵ��Ӵ�
                    // �� ["foo","bar","foo","the"]  "| foobarfoobar| foothe"
                    // �ڶ���bar��Ȼ��words[]�еĵ��ʣ����Ǵ������ˣ���ô����һ�����ʳ��Ⱥ� "|barfoobarfoo|the"
                    // bar���ǲ����ϣ�����ֱ�Ӵ���������ϵ�bar֮��ʼƥ�䣬Ҳ���ǽ���������ϵ�bar����֮ǰ�ĵ���(��)ȫ�Ƴ�ȥ
                    while (subMap.getOrDefault(word, 0) > wordsMap.getOrDefault(word, 0)) {
                        // �ӵ�ǰ�����ַ�ͳ��map��ɾ�����󴰿ڿ�ʼ���������޵����е���(������һ)
                        String w = s.substring(left, left + oneLen);
                        subMap.put(w, subMap.getOrDefault(w, 0) - 1);
                        // ���ϵĵ�������һ
                        --count;
                        // �󴰿�λ������
                        left += oneLen;
                    }
                    // ��ǰ�����ַ�������Ҫ��
                    if (count == words.length) res.add(left);
                }
            }
        }
        return res;
    }




    static HashSet<String> set;
    //��ʱ
    public List<Integer> findSubstring(String s, String[] words) {
        set = new HashSet<>();
        process(words, 0, words.length);
        int len = words[0].length() * words.length;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i <= s.length() - len; i++) {
            if (set.contains(s.substring(i, i + len))) {
                l.add(i);
            }
        }
        return l;
    }

    public static void process(String[] words, int location, int end) {
        if (location == end) {
            StringBuilder sb = new StringBuilder();
            for (String s : words) {
                sb.append(s);
            }
            set.add(sb.toString());
            return;
        }
        for (int i = location; i < words.length; i++) {
            swap(words, i, location);
            process(words, location + 1, end);
            swap(words, location, i);
        }
    }

    public static void swap(String[] words, int i, int j){
        String tem = words[i];
        words[i] = words[j];
        words[j] = tem;
    }

}
