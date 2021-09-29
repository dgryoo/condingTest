package ct;

import java.util.ArrayList;
import java.util.Scanner;

public class NAndM02 {

    static int N;
    static int M;
    static int[] array;
    public static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> numList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        N = scanner.nextInt();
        M = scanner.nextInt();
        array = new int[M + 1];

        for (int num = 1; num <= N; num++) {
            numList.add(num);
        }
        func(1, numList);
        System.out.println(sb.toString());
    }

    public static void func(int k, ArrayList<Integer> numberList) {

        if (k == M + 1) {
            for (int index = 1; index <= M; index++) {
                sb.append(array[index]).append(" ");
            }
            sb.append('\n');
        } else {
            for (int cand = 0; cand <=N; cand++) {
                if (!numberList.contains(cand)) continue;
                array[k] = cand;
                numberList.remove(Integer.valueOf(cand));
                func(k + 1, numberList);
                numberList.add(cand);
            }
        }

    }


}

//        문제
//        자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//
//        1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
//        입력
//        첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
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
//        1 2
//        1 3
//        1 4
//        2 1
//        2 3
//        2 4
//        3 1
//        3 2
//        3 4
//        4 1
//        4 2
//        4 3
//        예제 입력 3
//        4 4
//        예제 출력 3
//        1 2 3 4
//        1 2 4 3
//        1 3 2 4
//        1 3 4 2
//        1 4 2 3
//        1 4 3 2
//        2 1 3 4
//        2 1 4 3
//        2 3 1 4
//        2 3 4 1
//        2 4 1 3
//        2 4 3 1
//        3 1 2 4
//        3 1 4 2
//        3 2 1 4
//        3 2 4 1
//        3 4 1 2
//        3 4 2 1
//        4 1 2 3
//        4 1 3 2
//        4 2 1 3
//        4 2 3 1
//        4 3 1 2
//        4 3 2 1