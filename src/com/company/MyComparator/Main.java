package com.company.MyComparator;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student[] s = new Student[3];
        Student s1 = new Student("1","2");
        Student s2 = new Student("5","2");
        Student s3 = new Student("5","3");
        s[2] = s1;
        s[1] = s2;
        s[0] = s3;
        Arrays.sort(s, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return Integer.parseInt(o1.age) == Integer.parseInt(o2.age) ?
                        Integer.parseInt(o1.Num) - Integer.parseInt(o2.Num):
                        Integer.parseInt(o1.age) - Integer.parseInt(o2.age);
            }
        });
        System.out.println(s);
    }
    public static class Student{
        String age;

        String Num;

        @Override
        public String toString() {
            return "Student{" +
                    "age='" + age + '\'' +
                    ", Num='" + Num + '\'' +
                    '}';
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getNum() {
            return Num;
        }

        public void setNum(String num) {
            Num = num;
        }

        public Student(String age, String num) {
            this.age = age;
            Num = num;
        }
    }

//    public static class My implements Comparator<Student> {
//
//
//        @Override
//        public int compare(Student o1, Student o2) {
//            return o2.age- o1.age;
//        }
//    }

}

