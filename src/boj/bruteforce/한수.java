package boj.bruteforce;

import java.util.Scanner;

public class 한수 {

    static int N;
    static int answer;
    static String currentNum;
    static boolean isAvailable;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();


        if (N < 100) {
            answer = N;
            System.out.println(answer);
        } else {
            answer += 99;
            recFunc(100);
            System.out.println(answer);
        }

    }


    public static void recFunc(int k) {
        if (k != N + 1) {
            currentNum = String.valueOf(k);
            isAvailable = true;
            for (int index = 1; index < currentNum.length() - 1; index++) {
                if(currentNum.charAt(index) - currentNum.charAt(index-1) != currentNum.charAt(index+1) - currentNum.charAt(index)) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) answer++;
            recFunc(k + 1);
        }

    }

}
