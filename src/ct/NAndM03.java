package ct;

import java.util.Scanner;

public class NAndM03 {

    static int N;
    static int M;
    static int[] array;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        N = scanner.nextInt();
        M = scanner.nextInt();
        array = new int[M + 1];

        func(1);
        System.out.println(sb.toString());
    }

    public static void func(int k) {
        if (k == M + 1) {
            for (int index = 1; index <= M; index++) {
                sb.append(array[index]).append(" ");
            }
            sb.append('\n');
        } else {
            int start = array[k-1];
            if(start == 0) start = 1;
            for (int cand = start; cand <= N; cand++) {
                array[k] = cand;
                func(k + 1);
                array[k] = 0;
            }
        }
    }

}

// N번만큼 반복
// N번만큼 반복문 속에서 m개의 숫자를 고름
// recursiveCall 을 사용
// 자리수 m 까지의 자리수 필요 n까지의 숫자

//    https://www.acmicpc.net/problem/15651
//    N과 M (3)
//    시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
//1 초	512 MB	27352	17969	13758	65.919%
//        문제
//        자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//
//        1부터 N까지 자연수 중에서 M개를 고른 수열
//        같은 수를 여러 번 골라도 된다.
//        입력
//        첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
//
//        출력
//        한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
//
//        수열은 사전 순으로 증가하는 순서로 출력해야 한다.
//
//        예제 입력 1
//        3 1
//        예제 출력 1
//        1
//        2
//        3
//        예제 입력 2
//        4 2
//        예제 출력 2
//        1 1
//        1 2
//        1 3
//        1 4
//        2 1
//        2 2
//        2 3
//        2 4
//        3 1
//        3 2
//        3 3
//        3 4
//        4 1
//        4 2
//        4 3
//        4 4
//        예제 입력 3
//        3 3
//        예제 출력 3
//        1 1 1
//        1 1 2
//        1 1 3
//        1 2 1
//        1 2 2
//        1 2 3
//        1 3 1
//        1 3 2
//        1 3 3
//        2 1 1
//        2 1 2
//        2 1 3
//        2 2 1
//        2 2 2
//        2 2 3
//        2 3 1
//        2 3 2
//        2 3 3
//        3 1 1
//        3 1 2
//        3 1 3
//        3 2 1
//        3 2 2
//        3 2 3
//        3 3 1
//        3 3 2
//        3 3 3
