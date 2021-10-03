package programmers.greedy;

public class Greedy0202 {

    public static void main(String[] args) {

//        "JEROEN"	56
//        "JAN"	23


        String name = "ZAAAZZZZZZZ";

        int result = solution(name);

        System.out.println("");
        System.out.println(result);

    }

    static int solution(String name) {
        int answer = 0;
        boolean end = false;

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) - 'A' < 'Z' - name.charAt(i) + 1) {
                answer += name.charAt(i) - 'A';
            } else {
                answer += 'Z' - name.charAt(i) + 1;
            }
        }


        int startIndex = 0;
        int beforeIndex = 0;

        while (!end) {
            if (startIndex == name.length()-1) {

                break;

            }
            System.out.println("시작");
            System.out.print("startIndex : " + startIndex);
            for (int searchIndex = startIndex + 1; searchIndex < name.length(); searchIndex++) {
//                System.out.print(", si : " + searchIndex);
                if (name.charAt(searchIndex) != 'A') {
                    if (searchIndex - startIndex < name.length() - searchIndex + startIndex) {
                        answer += searchIndex - startIndex;
                        beforeIndex = startIndex;
                        startIndex = searchIndex;
                        System.out.println(", nextStart : " + startIndex);
                        break;
                    } else {
                        answer += name.length() - searchIndex + startIndex;
                        end = true;
                        break;
                    }
                }


            } // for end
            if(startIndex == beforeIndex) {
                break;
            }

        }


        return answer;

    }

    static int solution2(String name) {

        int answer = 0;
        int startIndex = 0;
        int beforeIndex = 0;
        boolean end = true;

        while (end) {

            // 알파벳 계산
            if (name.charAt(startIndex) - 'A' < 'Z' - name.charAt(startIndex) + 1) {
                answer += name.charAt(startIndex) - 'A';
            } else {
                answer += 'Z' - name.charAt(startIndex) + 1;
            }

            if (startIndex == name.length() - 1) {
                end = false;
                break;
            }

            // 다음 인덱스 위치 계산
            int nextIndex = 0;

            for (int s = startIndex + 1; s < name.length(); s++) {
                if (name.charAt(s) != 'A') {
                    nextIndex = s;
                    break;
                }
            }

            if (beforeIndex == nextIndex) {
                return answer;
            }

            // 인덱스 거리계산

            if (nextIndex - startIndex < name.length() - nextIndex + startIndex) {
                answer += nextIndex - startIndex;
            } else {
                answer += name.length() - nextIndex + startIndex;
            }

            beforeIndex = startIndex;
            startIndex = nextIndex;

            System.out.println(", answer : " + answer);
        }

        return answer;

    }

}

//조이스틱
//        문제 설명
//        조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
//        ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
//
//        조이스틱을 각 방향으로 움직이면 아래와 같습니다.
//
//        ▲ - 다음 알파벳
//        ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
//        ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
//        ▶ - 커서를 오른쪽으로 이동
//        예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.
//
//        - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
//        - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
//        - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
//        따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
//        만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
//
//        제한 사항
//        name은 알파벳 대문자로만 이루어져 있습니다.
//        name의 길이는 1 이상 20 이하입니다.
//        입출력 예
//        name	return
//        "JEROEN"	56
//        "JAN"	23

// 풀이
// 문자열 이동개수 구하기 : 아스키코드에서 A는 65 알파벳은 총 26개 뒤로가는거 +1고려해야함
// 다음 타겟 index 구하기 : 다음 타겟 index의 위치가 현재 인덱스에서 끝까지 while문을 써서 break가 걸리게끔 하자