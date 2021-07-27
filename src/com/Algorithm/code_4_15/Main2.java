package com.Algorithm.code_4_15;

import java.util.*;

/**
 * 一般在代码Code Review或者持续集成过程中，
 * 一次代码提交会触发代码的重新编译及正在Review过程的Pull Request的Approval重置，
 * 为了加快编译或者只重置受影响的Pull Reqeust，都会进行代码包依赖分析，找出受影响的代码包(package)。
 * 我们使用正整数表示包，对给定的被修改的包，求出所有受影响的包(去重)所代表数字的和，
 * 若无受影响的包，则和返回-1。注意，直接依赖及间接依赖的包被修改，当前包均被定义为受影响。
 *
 * 输入
 * 第一行为整数，代表被修改的包。 第二行开始的后续行都是数组，
 * 代表数组的第一个元素依赖后续的元素，注意数组元素可能只有1个，代表该包无依赖。
 * 如输入样例的含义为被修改的包是4，包1依赖2, 包3依赖4、5、6,  包2依赖3,  包6依赖4、2, 包8依赖9，包10无依赖。
 *
 * 输出
 * 所有受影响的包去重后为1、2、3、6，所以其和为12.
 *
 * 样例
 * 4
 * 1,2
 * 3,4,5,6
 * 2,3
 * 6,4,2
 * 8,9
 * 10
 *
 * 输出 12
 *
 * 依赖关系中可能有环，也可能有部分包与其它包之间没有依赖关系。另外，不用考虑求和时整数溢出。
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();  // 被修改的包
        sc.nextLine();  // 坑

        ArrayList<int[]> input = new ArrayList<>();
        while(sc.hasNext()){
            String[] split = sc.nextLine().split(",");
            input.add(toIntArray(split));
        }

//        int num = 4;
//        input.add(new int[]{1, 2});
//        input.add(new int[]{3, 4, 5, 6});
//        input.add(new int[]{2, 3});
//        input.add(new int[]{6, 4, 2});
//        input.add(new int[]{8, 9});
//        input.add(new int[]{10});

        if(input==null || input.size()==0){
            System.out.println(-1);
            return;
        }

        int ret = process(num, input);
//        System.out.println(set);
//        System.out.println(map);
        if(set.size()>0) {
            System.out.println(ret);
        }else{
            System.out.println(-1);
        }
    }


    static HashSet<Integer> set = new HashSet<>();  // 結果集
    //    key 影响 values
    static HashMap<Integer, HashSet<Integer>> map = new HashMap<>();  // key -> 受key影响的包set


    private static int process(int num, ArrayList<int[]> input) {
        /*
            2    1,6
            4    3,6
            5    3
            6    3
            3    2
            9    8
        */
        // 建立关系map
        for (int[] ints : input) {
            if(ints.length == 1){
                continue;
            }
            int ref = ints[0];  // 依賴別人的數
            for (int i = 1; i < ints.length; i++) {
                HashSet<Integer> depends = map.getOrDefault(ints[i], new HashSet<Integer>());
                depends.add(ref);
                map.put(ints[i], depends);
            }
        }

        recursive(num);  // 把要的东西丢到set里面去

        // 求和返回
        int ret = 0;
        for (Integer each : set) {
            ret+=each;
        }
        return ret;
    }


    private static void recursive(int num){
        HashSet<Integer> influenced = map.get(num);
        if(influenced==null || influenced.isEmpty() /*|| set.contains(num)*/) return;

        for (Integer each : influenced) {
            if (!set.contains(each)) {  // 已经包含了就不要再递归了
                set.add(each);
                recursive(each);
            }
        }
    }

    // 字符串数组转整型数组
    private static int[] toIntArray(String[] strs){
        int[] in = new int[strs.length];
        for (int i = 0; i < in.length; i++) {
            in[i] = Integer.parseInt(strs[i]);
        }
        return in;
    }
}
