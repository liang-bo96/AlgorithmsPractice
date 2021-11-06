package com.Algorithm.Zidianxu;

import com.Algorithm.TargetingOffer.N44;

import java.util.Arrays;

/**
 * 440. 字典序的第K小数字
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 *
 * 注意：1 ≤ k ≤ n ≤ 109。
 *
 * 示例 :
 *
 * 输入:
 * n: 13   k: 2
 *
 * 输出:
 * 10
 *
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
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
        long cur = 1; // 当前遍历到的数字，从1（根）出发
        k = k - 1; // 从1出发开始往后按字典序从小到大的顺序走k-1步到达的就是 字典序的第K小数字

        while(k > 0){
            int nodes = getNodes(n, cur);
            if(k >= nodes){ // 向右侧节点走：字典序上升nodes位
                k =  k - nodes;
                cur++;  // 当前数字 cur = cur + 1
            }else{ // 向下往最左孩子节点走:字典序上升1位
                k = k - 1;
                cur *= 10;  // 当前数字 cur = cur * 10
            }
        }
        return (int)cur; // 最后cur停在的数字就是字典序的第K小数字
    }

    // 计算以cur为根的子树节点数目，所有节点的值必须 <= n
    private int getNodes(int n, long cur){
        long next = cur + 1; // 当前节点右侧右边节点的值
        long totalNodes = 0; // 记录子树中的全部节点数目
        while(cur <= n){
            totalNodes += Math.min(n - cur + 1, next - cur);
            next *= 10;
            cur *= 10;
        }
        return (int)totalNodes;
    }
    //超时
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
