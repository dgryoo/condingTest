package boj.bruteforce;

// https://www.acmicpc.net/problem/2231

import java.util.Scanner;

public class 분해합 {

    static int N, value;
    static int min = 0;
    static String currentString;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        recFunc(N);

        System.out.println(min);
    }

    public static void recFunc(int targetNum) {
        for(int num = 1; num <= targetNum; num++) {
           currentString = String.valueOf(num);
           value = num;
           for(int index = 0; index <currentString.length(); index++) {
               value += currentString.charAt(index) - '0';
           }
           if(value == targetNum) {
               min = num;
               break;
           }
        }
    }
}
