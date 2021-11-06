package com.Algorithm.Zidianxu;

import com.Algorithm.TargetingOffer.N44;

import java.util.Arrays;

/**
 * 440. �ֵ���ĵ�KС����
 * �������� n �� k���ҵ� 1 �� n ���ֵ���� k С�����֡�
 *
 * ע�⣺1 �� k �� n �� 109��
 *
 * ʾ�� :
 *
 * ����:
 * n: 13   k: 2
 *
 * ���:
 * 10
 *
 * ����:
 * �ֵ���������� [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]�����Եڶ�С�������� 10��
 */
public class N440_KthSmallestOrder {
    public static void main(String[] args) {
        System.out.println(new N440_KthSmallestOrder().findKthNumber1(13, 3));
        int x = 0;
        int y = 0;
        for (int i = 1; i <= 20 ; i++) {
            for (int j = 1; j <= 20 ; j++) {
                if(Math.abs(i-j) > 3){
                    x++;
                }
            }
        }
        System.out.println((double) 272 / 400);
    }
    //reference
    public int findKthNumber1(int n, int k) {
        long cur = 1; // ��ǰ�����������֣���1����������
        k = k - 1; // ��1������ʼ�����ֵ����С�����˳����k-1������ľ��� �ֵ���ĵ�KС����

        while(k > 0){
            int nodes = getNodes(n, cur);
            if(k >= nodes){ // ���Ҳ�ڵ��ߣ��ֵ�������nodesλ
                k =  k - nodes;
                cur++;  // ��ǰ���� cur = cur + 1
            }else{ // �����������ӽڵ���:�ֵ�������1λ
                k = k - 1;
                cur *= 10;  // ��ǰ���� cur = cur * 10
            }
        }
        return (int)cur; // ���curͣ�ڵ����־����ֵ���ĵ�KС����
    }

    // ������curΪ���������ڵ���Ŀ�����нڵ��ֵ���� <= n
    private int getNodes(int n, long cur){
        long next = cur + 1; // ��ǰ�ڵ��Ҳ��ұ߽ڵ��ֵ
        long totalNodes = 0; // ��¼�����е�ȫ���ڵ���Ŀ
        while(cur <= n){
            totalNodes += Math.min(n - cur + 1, next - cur);
            next *= 10;
            cur *= 10;
        }
        return (int)totalNodes;
    }
    //��ʱ
    public int findKthNumber(int n, int k) {
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = intString(i + 1);
        }
        Arrays.sort(s);
        return Integer.parseInt(s[k - 1]);

    }
    public static String intString(int n){
        StringBuilder re = new StringBuilder();
        while ( n != 0){
            re.append( n % 10 );
            n /= 10;
        }
        return re.reverse().toString();
    }
}
