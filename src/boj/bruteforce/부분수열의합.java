package boj.bruteforce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1182
public class 부분수열의합 {

    static int N, S, ans;
    static int[] nums;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N= sc.nextInt();
        S = sc.nextInt();

        nums = new int[N+1];

        for(int i = 1; i<=N; i++) {
            nums[i] = sc.nextInt();
        }

        recFunc(1,0);
        if( S == 0) {
            ans--;
        }
        System.out.println(ans);
    }

    static void recFunc(int k, int value) {
        if( k == N + 1) {
            if( value ==  S) ans++;
        } else {
            // k번쨰 원소를 포함하고 싶음
            recFunc(k+1, value+nums[k]);

            // k번째 원소를 포함하기 싫음
            recFunc(k+1, value);
        }
    }

}
