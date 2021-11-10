package com.Algorithm.MergerInterval;

/**
 * 605. �ֻ�����
 * ������һ���ܳ��Ļ�̳��һ���ֵؿ���ֲ�˻�����һ����ȴû�С����ǣ���������ֲ�����ڵĵؿ��ϣ����ǻ�����ˮԴ�����߶�����ȥ��
 *
 * ����һ����������  flowerbed ��ʾ��̳�������� 0 �� 1 ��ɣ����� 0 ��ʾû��ֲ����1 ��ʾ��ֲ�˻�������һ���� n ���ܷ��ڲ�������ֲ�������������� n �仨�����򷵻� true �������򷵻� false��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺flowerbed = [1,0,0,0,1], n = 1
 * �����true
 * ʾ�� 2��
 *
 * ���룺flowerbed = [1,0,0,0,1], n = 2
 * �����false
 */
public class N605_PlaceFlower {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length; i++){

            if(flowerbed[i] == 0
                    && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)
                    && (i == 0 || flowerbed[i - 1] == 0)) {
                count++;
                flowerbed[i] = 1;
            }
        }
        return count >= n;
    }
}
