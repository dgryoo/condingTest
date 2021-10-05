package boj.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Boj14888 {

    static int N, max, min;
    static int nums[];
    static int operators[] = new int[5];
    static int order[];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

//        2
//        5 6
//        0 0 1 0

        N = sc.nextInt();
        nums = new int[N + 1];
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) nums[i] = sc.nextInt();
        for (int i = 1; i <= 4; i++) operators[i] = sc.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        recFunc(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());


    }

    static int calculator() {
        // nums, order
        int value = nums[1];
        for (int i = 1; i <= N; i++) {
            if (order[i] == 1) value = value + nums[i + 1];
            if (order[i] == 2) value = value - nums[i + 1];
            if (order[i] == 3) value = value * nums[i + 1];
            if (order[i] == 4) value = value / nums[i + 1];
        }
        System.out.println(value);
        return value;
    }

    static void recFunc(int k) {
        if (k == N) {
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int cand = 1; cand <= 4; cand++) {
                if (operators[cand] >= 1) {
                    operators[cand]--;
                    order[k] = cand;
                    recFunc(k + 1);
                    operators[cand]++;
                    order[k] = 0;

                }
            }
        }
    }

}
