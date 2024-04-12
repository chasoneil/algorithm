package com.chason.class04._02_比较器;

import com.chason.utils.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Checker {

    @Test
    public void sortBaseTest () {

        // 基本数据类型 系统会提供一些排序方法

        // 1. 数组

        int[] arr = new int[] {1, 3, 2, 6, 9, 4};
        ArrayUtils.printArray(arr);
        Arrays.sort(arr);
        ArrayUtils.printArray(arr);

        System.out.println("=======================");

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(9);
        list.add(4);
        ArrayUtils.printArray(list);
        // list.sort(xxx);  list也会提供用于排序的方法

    }

    @Test
    public void testComp () {

        MyComparator.Student student1 = new MyComparator.Student("A", 18, 3);
        MyComparator.Student student2 = new MyComparator.Student("B", 15, 7);
        MyComparator.Student student3 = new MyComparator.Student("C", 20, 1);

        MyComparator.Student[] students = new MyComparator.Student[] {student1, student2, student3};
        printStudent(students);

        System.out.println("====== sorted =====");
        Arrays.sort(students, new MyComparator.AgeAesComp());
        printStudent(students);
    }



    private static void printStudent (MyComparator.Student[] students) {

        for (int i=0; i<students.length; i++) {
            System.out.println("Name:" + students[i].name + " Age:" + students[i].age + " ID:" + students[i].studentId);
        }
    }


}
