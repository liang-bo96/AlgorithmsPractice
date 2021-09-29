package com.Algorithm.Leetcode;

/**
 * 470. �� Rand7() ʵ�� Rand10()
 * ���з��� rand7 ������ 1 �� 7 ��Χ�ڵľ��������������дһ������ rand10 ���� 1 �� 10 ��Χ�ڵľ������������
 *
 * ��Ҫʹ��ϵͳ�� Math.random() ������
 *
 *
 *
 * ʾ�� 1:
 *
 * ����: 1
 * ���: [7]
 * ʾ�� 2:
 *
 * ����: 2
 * ���: [8,4]
 * ʾ�� 3:
 *
 * ����: 3
 * ���: [8,1,10]
 */
public class N470_Random7ToRandom10 {
    public int rand7(){
        return (int)(Math.random() * 7);
    }

    /**
     * ��֪ rand_N() ���Եȸ��ʵ�����[1, N]��Χ�������
     * ��ô��
     * (rand_X() - 1) �� Y + rand_Y() ==> ���Եȸ��ʵ�����[1, X * Y]��Χ�������
     * ��ʵ���� rand_XY()
     */
    public int rand10() {
        int num = 41;
        while(num > 40){
            num = (rand7()-1) * 7 + rand7();
        }
        return num % 10 + 1;
    }
}
