package com.Algorithm.SegmentTree;

public class segmenttree {
    private static int len = 100;
    private static int[] TreeArr = new int[len];
    public static void main(String[] args) {
        build_tree(new int[]{1,3,5,7,9,11},0,0,5);
        update_tree(0,0,5,4,6);
        for (int i = 0; i <  15;i ++){
            System.out.println(TreeArr[i]);
        }
        System.out.println("==================total==============");
        System.out.println(query_tree(0,0,5,0,3));
    }
    public static void build_tree(int[] arr,int cur_node ,int start,int end){
        if(start == end){
            TreeArr[cur_node] = arr[start];
            return;
        }
        int left_node = cur_node * 2 + 1;
        int right_node = cur_node * 2 + 2;
        int mid = (start + end )/ 2;
        build_tree(arr,left_node,start,mid);
        build_tree(arr,right_node,mid + 1,end);
        TreeArr[cur_node] = TreeArr[left_node] + TreeArr[right_node];
    }

    public static void update_tree(int cur_node ,int start,int end,int key, int val){
        System.out.println(start+"  "+end);
        if(start == end && start == key){
            TreeArr[cur_node] = val;
            return;
        }
        int mid = (start + end) / 2;
        System.out.println(mid);
        int left_node = cur_node * 2 + 1;
        int right_node = cur_node * 2 + 2;
        if(key <= mid){
            update_tree(left_node,start,mid,key,val);
        }else{
            update_tree(right_node,mid+1,end,key,val);
        }
        TreeArr[cur_node] = TreeArr[left_node] + TreeArr[right_node];
    }

    public static int query_tree(int cur_node,int start,int end,int L,int R){
        int mid = (start + end) / 2;
        int left_node = cur_node * 2 + 1;
        int right_node = cur_node * 2 + 2;
        if(start > R || end < L){
            return 0;
        }else if(start == L && end == R || start == end){
            return TreeArr[cur_node];
        }else{
            int left_value = query_tree(left_node, start,mid,L,R);
            int right_value = query_tree(right_node,mid+1,end,L,R);
            return left_value + right_value;
        }
    }
}
