package com.mashibing.juc.c_023_Singleton;

public class Practice_Singleton {
/**
 * ˫�ؼ��
 * ��volatile��������new���̷�Ϊ������1�������ڴ� 2����ʼ������ 3��ָ��ָ��շ���ĵ�ַ
 * ����volatile�ᵼ��ָ�������� 1-2-3���1-3-2��Ҳ����������δ��ʼ���Ķ��������Ҫ��volatile
 *
 */
//    private static volatile Practice_Singleton instance;
//
//    private Practice_Singleton(){}
//    public static Practice_Singleton getInstance(){
//        if(instance == null){
//            synchronized (Practice_Singleton.class){
//                if (instance == null){
//                    instance = new Practice_Singleton();
//                }
//            }
//        }
//        return instance;
//    }
    /**
     * ��̬�ڲ���
     * ��������̰߳�ȫ��
     */
    private Practice_Singleton(){}


    private static class Inner {
        private static final Practice_Singleton instance = new Practice_Singleton();
    }

    public static Practice_Singleton getInstance(){
        return Inner.instance;
    }

}
