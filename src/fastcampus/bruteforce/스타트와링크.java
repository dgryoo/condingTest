package fastcampus.bruteforce;

import java.util.Scanner;

// 중복을 허용하지 않고 M개를 고르기

public class 스타트와링크 {
    static int N, min;
    static int[][] score;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        used = new boolean[N + 1];
        score = new int[N+1][N+1];
        min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                score[i][j] = sc.nextInt();
            }
        }

        recFunc(1, 1);
        System.out.println(min);
    }

    private static void recFunc(int startIndex, int k) {
        if (k == N / 2 + 1) {
            min = Math.min(min, calculate());
        } else {
            for (int index = startIndex; index <= N; index++) {
                if (!used[index]) {
                    used[index] = true;
                    recFunc(index + 1, k + 1);
                    used[index] = false;
                }
            }
        }
    }

    private static int calculate() {
        int startTeamValue = 0;
        int linkTeamValue = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (used[i] && used[j]) startTeamValue += score[i][j] + score[j][i];
                if (!used[i] && !used[j]) linkTeamValue += score[i][j] + score[j][i];
            }
        }

        return Math.abs(startTeamValue - linkTeamValue);
    }


}
