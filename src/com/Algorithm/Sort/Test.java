package com.Algorithm.Sort;

import java.util.Arrays;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        A a = new A(5);
        A a1 = new A(10);
        System.out.println(a.compareTo(a1));
        A[] aa = {a1,a};
        Arrays.sort(aa);
        for ( A aaa:aa
             ) {
            System.out.println(aaa);
        }
//        System.out.println(aa);
    }
}
class A implements Comparable<A>{
    private int number;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof A)) return false;
        A a = (A) o;
        return number == a.number && name.equals(a.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }

    public A(int number) {
        this.number = number;
    }



    @Override
    public int compareTo(A o) {
        if(o.number>this.number) return 1;
        if (o.number<this.number) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "A{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
