package boj.bruteforce;

import java.util.Scanner;
// https://www.acmicpc.net/problem/2798
public class 블랙잭 {

    static int N, M;
    static int[] cards;
    static int closed = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        cards = new int[N + 1];

        for(int i = 1; i <=N; i++) {
            cards[i] = sc.nextInt();
        }

        recFunc(1, 0, 0);
        System.out.println(closed);
    }

    public static void recFunc(int index, int value, int count) {
        if(value <= M) {
            if (count == 3) {
                if (value > closed) closed = value;
            } else if (index <= N) {
                // 선택
                recFunc(index + 1, value + cards[index], count + 1);

                // 선택안함
                recFunc(index + 1, value, count);
            }
        }
    }

}
