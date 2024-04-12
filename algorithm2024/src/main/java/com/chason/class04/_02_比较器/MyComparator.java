package com.chason.class04._02_比较器;

import java.util.Comparator;

public class MyComparator {


    public static class Student {
        public String name;
        public int age;
        public int studentId;

        public Student (String name, int age, int studentId) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
        }
    }

    public static class AgeAesComp implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }





}
