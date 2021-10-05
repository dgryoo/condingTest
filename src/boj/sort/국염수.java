package boj.sort;

// https://www.acmicpc.net/problem/10825

import java.util.Arrays;
import java.util.Scanner;

public class 국염수 {

    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();

        Student[] students = new Student[N];

        for (int index = 0; index < N; index++) {
            students[index] = new Student();
            students[index].name = sc.next();
            students[index].korean = sc.nextInt();
            students[index].english = sc.nextInt();
            students[index].math = sc.nextInt();
        }

        Arrays.sort(students);

        for(int index =0; index < N; index++) {
            sb.append(students[index].name).append('\n');
        }

        System.out.println(sb.toString());


    }

    public static class Student implements Comparable<Student> {
        public String name;
        public int korean;
        public int english;
        public int math;

        @Override
        public int compareTo(Student s) {
            if (s.korean != korean) return s.korean - korean;
            if (s.english != english) return english - s.english;
            if (s.math != math) return s.math - math;
            return name.compareTo(s.name);

        }
    }

}
