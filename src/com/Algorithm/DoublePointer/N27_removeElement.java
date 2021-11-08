package com.Algorithm.DoublePointer;

import static com.Algorithm.DoublePointer.N75_sort_color.swap;

/*27. 移除元素
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1：

输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2]
解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
示例 2：

输入：nums = [0,1,2,2,3,0,4,2], val = 2
输出：5, nums = [0,1,4,0,3]
解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。*/
public class N27_removeElement {
    public static void main(String[] args) {
        System.out.println(new N27_removeElement().removeElement(new int[]{3, 2, 2, 3}, 3));
    }
    //左边是指一个指针，遍历数组，只要不等于val就移动到左边指针位置，保证了剩下元素的相对次序
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
    //把所有等于val的元素移动到数组末尾，前面的数组就符合要求，破坏了剩余元素的相对次序
    public int removeElement2(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int right = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] == val){
                swap(nums,i,right--);
            }
        }
        return right + 1;
    }
    //practice
    public int removeElement1(int[] nums, int val) {
        if (nums.length == 0) return nums.length;
        if (nums.length == 1 && nums[0] != val) return 1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < nums.length && nums[left] != val) {
                left++;
            }
            while (right >= 0 && nums[right] == val) {
                right--;
            }
            if (left >= right) break;
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return left;
    }
}
