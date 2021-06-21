package com.company.BackTracking;

import com.company.Leetcode.N46;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.company.Leetcode.N46.swap;
/*输入一个**不包含重复数字**的数组 `nums`，返回这些数字的全部排列。

```cpp
vector<vector<int>> permute(vector<int>& nums);
```

比如说输入数组 `[1,2,3]`，输出结果应该如下，顺序无所谓，不能有重复：

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]*/
public class PaiLie {
    static List<int[]> result ;
    public static void main(String[] args) {
        result = new LinkedList<>();
        paiLie(new int[]{1,2,3});
        System.out.println(result);
    }
    public static void paiLie(int[]arr){
        process(arr,0,arr.length);
    }
    public static void process(int[] arr,int tem,int end){
        if(tem == end){
            result.add(Arrays.copyOf(arr,arr.length));
            return;
        }
        for (int i = tem; i < arr.length; i++) {
            swap(arr,tem,i);
            process(arr,tem+1,end);
            swap(arr,i,tem);
        }
    }

}
