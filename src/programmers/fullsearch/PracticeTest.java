package programmers.fullsearch;

import java.util.ArrayList;
import java.util.List;

public class PracticeTest {

    public static void main(String[] args) {

        int[] answers = {1,3,2,4,2};

        int[] result = solution(answers);

        for(int i : result) {
            System.out.println(i);
        }

//        int[] answers = {1, 3, 2, 4, 2};
//
//        int[] testMethod = {1, 2, 3, 4, 5};
//
//        int student01 = 0;
////  1 = 0, 2 = 1, 3 = 2, 4 = 3, 5 = 0
//        for (int i = 1; i < answers.length + 1; i++) {
//            int recentAnswer = answers[i - 1];
//            System.out.println(i + "번째 답 : " + recentAnswer);
//            int recentStudentAnswer = testMethod[i % 5 - 1];
//            System.out.println("학생의 답 : " + recentStudentAnswer);
//            if (i % 5 == 0) {
//                if (testMethod[4] == recentAnswer) student01 = student01 + 1;
//            } else {
//                if (testMethod[(i % 5) - 1] == recentAnswer) student01 = student01 + 1;
//            }
//        }
    }


    public static int[] solution(int[] answers) {
        List<Integer> answerList = new ArrayList<>();

        int[] method01 = {1, 2, 3, 4, 5};
        int[] method02 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] method03 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int student01 = 0;
        int student02 = 0;
        int student03 = 0;

        int maxScore;

        for (int i = 1; i < answers.length + 1; i++) {
            int recentAnswer = answers[i - 1];
            if (i % 5 == 0) {
                if (method01[4] == recentAnswer) student01 = student01 + 1;
            } else {
                if (method01[(i % 5) - 1] == recentAnswer) student01 = student01 + 1;
            }

            if (i % 8 == 0) {
                if (method02[7] == recentAnswer) student02 = student02 + 1;
            } else {
                if (method02[(i % 8) - 1] == recentAnswer) student02 = student02 + 1;
            }

            if (i % 10 == 0) {
                if (method02[9] == recentAnswer) student03 = student03 + 1;
            } else {
                if (method03[(i % 10) - 1] == recentAnswer) student03 = student03 + 1;
            }

        }

        if (student01 > student02) {
            maxScore = student01;
        } else {
            maxScore = student02;
        }

        if (student03 > maxScore) {
            maxScore = student03;
        }

        if (student01 == maxScore) answerList.add(1);
        if (student02 == maxScore) answerList.add(2);
        if (student03 == maxScore) answerList.add(3);

        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}

//모의고사
//        문제 설명
//        수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
//
//        1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//        2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//        3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//
//        1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//        제한 조건
//        시험은 최대 10,000 문제로 구성되어있습니다.
//        문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
//        가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
//        입출력 예
//        answers	return
//        [1,2,3,4,5]	[1]
//        [1,3,2,4,2]	[1,2,3]
//        입출력 예 설명
//        입출력 예 #1
//
//        수포자 1은 모든 문제를 맞혔습니다.
//        수포자 2는 모든 문제를 틀렸습니다.
//        수포자 3은 모든 문제를 틀렸습니다.
//        따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
//
//        입출력 예 #2
//
//        모든 사람이 2문제씩을 맞췄습니다.