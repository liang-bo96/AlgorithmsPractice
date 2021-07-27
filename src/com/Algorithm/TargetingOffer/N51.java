package com.Algorithm.TargetingOffer;

import java.util.HashMap;

public class N51 {
    public static void main(String[] args) {
        int[] n = new int[]{7,5,6,4};
        System.out.println(reversePairs(n));
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0,1);
        System.out.println(map.containsKey(1));
    }
        public static int reversePairs(int[] nums) {
            // int re = 0;
            // for(int i = 0;i < nums.length;i++){
            //     for(int j = i;j<nums.length;j++){
            //         if(nums[j]<nums[i]){
            //             re++;
            //         }
            //     }
            // }
            // return re;
            if(nums.length == 0 || nums.length == 1) return 0;
            int[] tem = new int[nums.length];
            for (int i = 0;i<nums.length;i++){
                tem[i] = nums[i];
            }
            return reversePairs(nums,0,nums.length-1,tem);
        }

        public static int reversePairs(int[] nums,int start,int end,int[] tem){
            if(start >= end) return 0;
            int mid = (start+end) /2;
            int leftReversePairs = reversePairs(nums,start,mid,tem);
            int rightReversePairs = reversePairs(nums,mid+1,end,tem);
            return leftReversePairs+rightReversePairs+merge(nums,start,end,tem);
        }
        //     private int reversePairs(int[] nums, int left, int right, int[] temp) {
//         if (left == right) {
//             return 0;
//         }

//         int mid = left + (right - left) / 2;
//         int leftPairs = reversePairs(nums, left, mid, temp);
//         int rightPairs = reversePairs(nums, mid + 1, right, temp);

//         if (nums[mid] <= nums[mid + 1]) {
//             return leftPairs + rightPairs;
//         }

//         int crossPairs = mergeAndCount(nums, left, mid, right, temp);
//         return leftPairs + rightPairs + crossPairs;
//     }

        public static int merge(int[] nums, int start,int end ,int[] tem){
            if(start>=end) return 0;
            int count = 0;
            int mid = (start+end)/2;
            int i = start;
            int j = mid + 1;
            for(int k = start ; k <end ; k++){
                if(i == mid+1){
                    nums[k] = tem[j];
                    j++;
                }else if(j == end+1){
                    nums[k] = tem[i];
                    i++;
                }else if(tem[i]<=tem[j]){
                    nums[k] = tem[i];
                    i++;
                }else{
                    nums[k] = tem[j];
                    count += (mid - i + 1);
                    j++;

                }
            }
            return count;
        }
    }
//     private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
//         for (int i = left; i <= right; i++) {
//             temp[i] = nums[i];
//         }

//         int i = left;
//         int j = mid + 1;

//         int count = 0;
//         for (int k = left; k <= right; k++) {

//             if (i == mid + 1) {
//                 nums[k] = temp[j];
//                 j++;
//             } else if (j == right + 1) {
//                 nums[k] = temp[i];
//                 i++;
//             } else if (temp[i] <= temp[j]) {
//                 nums[k] = temp[i];
//                 i++;
//             } else {
//                 nums[k] = temp[j];
//                 j++;
//                 count += (mid - i + 1);
//             }
//         }
//         return count;
//     }
// }

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

