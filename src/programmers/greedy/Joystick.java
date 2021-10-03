package programmers.greedy;

public class Joystick {

    public static void main(String[] args) {
        String test = "ZAAAZZZZZZZ";
        System.out.println(solution(test));


    }
    // A 가 아닌 가장 가까운곳으로 이동하도록 수정

    public static int solution(String name) {
        int answer = 0;
        int endCount = 0;

        boolean[] isFinish = new boolean[name.length()];

        // 알파벳 계산
        for (int index = 0; index < name.length(); index++) {
            if (name.charAt(index) != 'A') {
                isFinish[index] = false;
                if (name.charAt(index) - 'A' < 'Z' - name.charAt(index) + 1) {
                    answer += name.charAt(index) - 'A';
                } else {
                    answer += 'Z' - name.charAt(index) + 1;
                }
            } else {
                isFinish[index] = true;
                endCount++;
            }
        }

        // greedy search
        int currentIndex = 0;
        int targetIndex = 0;

        while (true) {

            if (!isFinish[currentIndex]) {
                isFinish[currentIndex] = true;
                endCount++;
            }

            if (endCount == isFinish.length) break;

            for (int index = 1; index < isFinish.length; index++) {
                if (isFinish[index] == false) {
                    targetIndex = index;
                    break;
                }
            }

            // left or right
            int left = 0;
            int right = 0;

            if (targetIndex > currentIndex) {
                left = isFinish.length - targetIndex + currentIndex;
                right = targetIndex - currentIndex;
            }
            if (targetIndex < currentIndex) {
                left = currentIndex - targetIndex;
                right = isFinish.length - currentIndex + targetIndex;
            }

            if (left < right) {
                if (currentIndex - 1 < 0) {
                    currentIndex = name.length() - 1;
                } else {
                    currentIndex--;
                }
            } else {
                currentIndex++;
            }
            answer++;

        }
        return answer;
    }
}
