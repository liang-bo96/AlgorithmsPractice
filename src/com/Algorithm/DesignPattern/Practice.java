package com.Algorithm.DesignPattern;

import java.sql.PreparedStatement;
import java.time.Instant;

public class Practice {
    private Practice(){}
    private volatile static Practice Instance;
    public static Practice getInstance(){
        if(Instance == null){
            synchronized (Practice.class){
                if(Instance == null){
                    Instance = new Practice();
                }
            }
        }
        return Instance;
    }
}
class Practice1{
    private Practice1(){}
    private static class Inner{
        private static final Practice1 re = new Practice1();
    }
    public static Practice1 getInstance(){
        return Inner.re;
    }
}
