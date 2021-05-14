package com.company.AAA;

public class Solution {
    public int[] sortArray(int[] nums) {
        // int len = nums.length;
        // for(int i = 0 ; i < len;i++){
        //     for(int j = 0 ; j < len - i-1;j++){
        //         if(nums[j] > nums[j+1]){
        //             int tem = nums[j];
        //             nums[j] = nums[j+1];
        //             nums[j+1] = tem;
        //         }
        //     }
        // }
        // return nums;

        return sort2(nums,0,nums.length-1);
    }
    public static int[] sort2(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            //左右归并
            merge2(a,low,mid,high);
        }
        return a;
    }

    public static void merge2(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }
    public static int[] sort(int[] nums , int left ,int right){
        if(left < right){
            int mid = (left + right)/2;
            sort(nums,left,mid);
            sort(nums,mid + 1,right);
            merge(nums,left,mid,right);
        }
        return nums;

    }
    public static void merge(int[]nums,int left,int mid,int right){
        int[] tem = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= right){
            if(nums[i] < nums[j]){
                tem[k] = nums[i];
                k++;
                i++;
            }else{
                tem[k] = nums[j];
                k++;
                j++;
            }
        }
        while(i <=mid){
            tem[k] = nums[i];
            k++;
            i++;
        }
        while(j < right){
            tem[k] = nums[j];
            k++;
            j++;
        }
        for(int x = 0;x < right-left+1;x++){
            nums[x+left] = tem[x];
        }
    }
    private static void QuickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if (left >= right) {
            return;
        }
        //设置最左边的元素为基准值
        int key = num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = left;
        int j = right;
        while (i < j) {
            //j向左移，直到遇到比key小的值
            while (num[j] >= key && i < j) {
                j--;
            }
            //i向右移，直到遇到比key大的值
            while (num[i] <= key && i < j) {
                i++;
            }
            //i和j指向的元素交换
            if (i < j) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
        num[left] = num[i];
        num[i] = key;

        QuickSort(num, left, i - 1);
        QuickSort(num, i + 1, right);
    }
    public static void sort1(int[] num , int start, int end){
        if(start >= end){
            return;
        }
        int i = partition(num,start,end);
        sort(num,start,i-1);
        sort(num,i+1,end);
    }
    public static int partition(int[] n ,int start,int end){
        int tem = n[start];
        int location = start;
        while(start < end){
            while(n[start+1] < tem){
                start++;
            }
            while(n[end] > tem){
                end --;
            }
            exchange(n,start,end);
        }
        exchange(n,location,start);
        return start;
    }
    public static void exchange(int[] n , int start,int end){
        int tem = n[start];
        n[start] = n[end];
        n[end] = tem;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,8,7,6,5,4,6};
        System.out.println(new Solution().sortArray(a));
        System.out.println(1);
    }
}