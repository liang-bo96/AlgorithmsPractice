package com.company.Casual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class TestHash {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student s1 = new Student("⼩张");
        Student s2 = new Student("⼩李");
        TestHash.swap(s1, s2);
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());
        new LinkedList<>();
        System.out.println(7 & 9);
        int[] a = {};
        System.out.println(a);
        HashMap<Object, Object> map = new HashMap<>();
        map.put(null,1);
        map.put(null,2);
        Object o = map.get(null);
        System.out.println("-------------"+o);

    }

    public static void swap(Student x, Student y) {
        x.setName("haha");
        y.setName("hehe");
    }
}
class Student{
    private String name;


    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
