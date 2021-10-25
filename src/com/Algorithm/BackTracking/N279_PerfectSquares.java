package com.Algorithm.BackTracking;

import java.util.*;

/**
 * 279. ��ȫƽ����
 * ���������� n���ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n������Ҫ����ɺ͵���ȫƽ�����ĸ������١�
 * <p>
 * ����һ������ n �����غ�Ϊ n ����ȫƽ������ �������� ��
 * <p>
 * ��ȫƽ���� ��һ����������ֵ������һ��������ƽ�������仰˵����ֵ����һ�������Գ˵Ļ������磬1��4��9 �� 16 ������ȫƽ�������� 3 �� 11 ���ǡ�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 12
 * �����3
 * ���ͣ�12 = 4 + 4 + 4
 * ʾ�� 2��
 * <p>
 * ���룺n = 13
 * �����2
 * ���ͣ�13 = 4 + 9
 */
public class N279_PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new N279_PerfectSquares().numSquares2(12));
    }

    static List<Integer> l;

    public int numSquares(int n) {
        l = new ArrayList<>();

        int i = 1;
        while (Math.pow(i, 2) <= n) {
            l.add((int) Math.pow(i, 2));
            i++;
        }


        return process(n, l, 0, 0, new HashMap<String, Integer>());
    }

    public static int process(int n, List<Integer> l, int location, int tem, HashMap<String, Integer> map) {
        if (map.containsKey(location + "-" + tem)) {
            return map.get(location + "-" + tem);
        }
        if (location == l.size()) {
            if (tem == n) {
                map.put(location + "-" + tem, 0);
                return 0;
            }
            map.put(location + "-" + tem, 99999999);
            return 99999999;
        }
        int t = Integer.MAX_VALUE;
        for (int i = 0; i * l.get(location) + tem <= n; i++) {
            t = Math.min(process(n, l, location + 1, tem + i * l.get(location), map) + i, t);
        }
        map.put(location + "-" + tem, t);
        return t;
    }

    // dp------��ʱ
    static Set<Integer> set;

    static {
        set = new HashSet<>();
        int i = 1;
        while (i * i < 10000) {
            set.add(i * i);
            i++;
        }
    }

    public int numSquares1(int n) {

        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
        }
        for (int i = 1; i < n + 1; i++) {
            if (set.contains(i)) {
                dp[i] = 1;
            } else {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
        }
        return dp[n];
    }

    //dp--references
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,n+ 1);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
