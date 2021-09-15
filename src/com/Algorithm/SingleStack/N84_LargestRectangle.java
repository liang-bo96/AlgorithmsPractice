package com.Algorithm.SingleStack;

/**
 * 84. ��״ͼ�����ľ���
 * ���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
 *
 * ���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������
 *
 *
 *
 * ʾ�� 1:
 *
 *
 *
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
    //��ʱ
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int max = 0;
        for(int i : heights){
            max = Math.max(max,i);
        }
        int result = 0;
        for (int i = 0; i <= max; i++) {
            int tem = 0;
            int index = 0;
            while(index < heights.length){
                if(heights[index] >= i){
                    tem += i;
                    result = Math.max(result,tem);
                }else{
                    tem = 0;
                }
                index++;
            }
        }
        return result;
    }
}
