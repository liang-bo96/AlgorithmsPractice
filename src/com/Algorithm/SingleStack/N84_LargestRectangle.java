package com.Algorithm.SingleStack;

import java.util.Stack;

/**
 * 84. ��״ͼ�����ľ���
 * ���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
 * <p>
 * ���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������
 * <p>
 * <p>
 * <p>
 * ʾ�� 1:
 * <p>
 * <p>
 * <p>
 * ���룺heights = [2,1,5,6,2,3]
 * �����10
 * ���ͣ����ľ���Ϊͼ�к�ɫ�������Ϊ 10
 * ʾ�� 2��
 *
 *
 *
 * ���룺 heights = [2,4]
 * ����� 4
 */
public class N84_LargestRectangle {
    public static void main(String[] args) {
        System.out.println(new N84_LargestRectangle().largestRectangleArea1(new int[]{2, 1, 5, 6, 2, 3}));
    }
    //��ʱ
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i : heights) {
            max = Math.max(max, i);
        }
        int result = 0;
        for (int i = 0; i <= max; i++) {
            int tem = 0;
            int index = 0;
            while (index < heights.length) {
                if (heights[index] >= i) {
                    tem += i;
                    result = Math.max(result, tem);
                } else {
                    tem = 0;
                }
                index++;
            }
        }
        return result;
    }
    //����ջ
    public static int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        int res = 0;
        int[] right = new int[heights.length];
        int[] left = new int[heights.length];
        //�ұ߱���С���±�--û�в�len
        for(int i = heights.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            right[i] =  stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        //��߱���С���±�--û�в�-1
        for(int i = 0; i < heights.length; i++){
            while(!stack1.isEmpty() && heights[i] <= heights[stack1.peek()]){
                stack1.pop();
            }
            left[i] =  stack1.isEmpty() ? -1 : stack1.peek();
            stack1.push(i);
        }
        //����
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res,heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}
