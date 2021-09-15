package com.BiliBili;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author : qizidog
 * @date : 2021-09-13 20:06
 * @description :
 * 小B正在玩一款2D射击游戏，当前关卡地图中总共有N只怪物，一个坐标点最多只有一只怪物。
 * 小B可以移动到地图中任意点开枪射击，小B的武器射击范围可以覆盖到整张地图，子弹击中怪物后会继续沿直线弹道飞行，直至飞出地图边界。
 *
 * 现在小B只有一发子弹，请问小B最多可以击中多少只怪物？
 *
 * 输入描述
 * 第一行：输入一个整数N（N＜500），表示N只怪物。
 *
 * 接下来N行格式要求：每一行输入2个整数，用空格区分，分别表示一只怪物的x坐标和y坐标。（坐标范围在[0,500000] ）
 *
 * 输出描述
 * 一个整数，表示小B击中怪物的最大数量。
 *
 * 样例输入
 * 2
 * 0 0
 * 0 1
 * 样例输出
 * 2
 **/

public class Main3 {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[][] pos = new int[n][2];
        // for (int i = 0; i < n; i++) {
        //     int x = sc.nextInt();
        //     int y = sc.nextInt();
        //     pos[i][0] = x;
        //     pos[i][1] = y;
        // }
        //
        // process(pos);

        process(new int[][]{{0,0}, {0,1}, {1,1}, {2,2}, {3,3}});
        process(new int[][]{{0,0}, {0,1}, {1,1}, {2,2}, {3,3}, {0,2}, {0,3}, {0,4}});
    }

    private static void process(int[][] pos) {
        if (pos==null || pos.length==0){
            System.out.println(0);
            return;
        }
        if (pos.length<3){
            System.out.println(pos.length);
            return;
        }
        HashMap<String, Integer> map = new HashMap<>();  // k-b, count
        int len = pos.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                String key = calcKB(pos[i][0], pos[i][1], pos[j][0], pos[j][1]);
                Integer val;
                if ((val = map.get(key))!=null){
                    map.put(key, val+1);
                }else{
                    map.put(key, 1);
                }
            }
        }
        int max = 0;
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }
                // (x-1)+1  * (x-1) = 2*max;
        int ret = (int) Math.pow(2*max, 0.5);
        // if (ret*(ret-1) == 2*max){
        //     System.out.println(ret);
        // }else if((ret+1)*ret == 2*max){  // 必走该分支
        //     System.out.println(ret+1);
        // }else{
        //     System.out.println(ret-1);
        // }
        System.out.println(ret+1);
    }

    private static String calcKB(int x1, int y1, int x2, int y2) {
        double k = ((double)(y2-y1))/(x2-x1);
        double b = y1 - k * x1;
        return String.format("%.4f", k)+"-"+String.format("%.4f", b);
    }
}