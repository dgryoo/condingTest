package boj.sort;

// https://www.acmicpc.net/problem/1015

// 완전탐색으로 풀면 O(n2)
// 정렬으로 풀면 O(n logn) + O(n) = O(n logn)


import java.util.Arrays;
import java.util.Scanner;

public class 수열정렬 {

    static int N;
    static int[] P;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        P = new int[N];
        Pair[] pairs = new Pair[N];

        for (int index = 0; index < N; index++) {
            pairs[index] = new Pair(sc.nextInt(), index);
        }

        Arrays.sort(pairs);

        for(int index = 0; index < N; index++) {
            P[pairs[index].index] = index;
        }

        for (int index = 0; index < N; index++) {
            sb.append(P[index]).append(' ');
        }

        System.out.println(sb.toString());
    }

    public static class Pair implements Comparable<Pair> {

        public int value;
        public int index;


        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair p) {
            if(value != p.value) return value - p.value;
            return index - p.index;
        }
    }


}
