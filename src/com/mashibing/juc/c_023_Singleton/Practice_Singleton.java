package com.mashibing.juc.c_023_Singleton;

public class Practice_Singleton {
/**
 * 双重检查
 * 加volatile的作用是new过程分为三步：1。分配内存 2。初始化对象 3。指针指向刚分配的地址
 * 不加volatile会导致指令重排序 1-2-3变成1-3-2，也就是外界会获得未初始化的对象，因此需要加volatile
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
     * 静态内部类
     * 类加载是线程安全的
     */
    private Practice_Singleton(){}


    private static class Inner {
        private static final Practice_Singleton instance = new Practice_Singleton();
    }

    public static Practice_Singleton getInstance(){
        return Inner.instance;
    }

}
