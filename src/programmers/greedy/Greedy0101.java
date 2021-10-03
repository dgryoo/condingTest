package programmers.greedy;

public class Greedy0101 {

    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;


        System.out.println(solution(number, k));
    }

    static String solution(String number, int k) {

        String answer = "";
        int startIndex = 0;
        int len = number.length() - k;

        // 목표 길이 len 만큼 진행하겠다.
        for (int i = 0; i < len; i++) {
            int max = 0;
            int recentIndex = 0;
            // 시작인덱스는 now 이고 i = 0 목표길이
            for (int j = startIndex; j <= i + k; j++) {
                int recentNum = number.charAt(j)  - '0';
                if (max < recentNum) {
                    recentIndex = j;
                    max = recentNum;
                }
            }
            answer = answer + max;
            startIndex = recentIndex + 1;
            System.out.println(startIndex);
        }
        return answer;
    }

}

//    큰 수 만들기
//        문제 설명
//        어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
//
//        예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
//
//        문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
//
//        제한 조건
//        number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
//        k는 1 이상 number의 자릿수 미만인 자연수입니다.
//        입출력 예
//        number	k	return
//        "1924"	2	"94"
//        "1231234"	3	"3234"
//        "4177252841"	4	"775841"
//        "31944"       3   "94"

// solution
// 앞자리가 k+1개 중에 가장 큰 자리수 까지 제거
// 제거할떄마다 k를 줄이자
