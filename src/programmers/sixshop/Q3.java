package programmers.sixshop;

import java.util.*;

public class Q3 {

    public static void main(String[] args) {
//        3	[4, 2, 2, 5, 3]	[2, 3, 1, 5, 4]
//        1	[100, 1, 50, 1, 1]	[1, 2, 3, 4, 5]
        int n = 1;
        int[] coffee_times = {100, 1, 50, 1, 1};
        System.out.println(Arrays.toString(solution(n, coffee_times)));

    }

    static int[] solution2(int n, int[] coffee_times) {

        // 커피추출 완료된 List
        List<Integer> complete = new ArrayList<>(coffee_times.length);

        // 커피머신
        List<Coffee> coffeeMachine = new ArrayList<>(n);

        // 커피머신에 넣은 최근 인덱스
        int index = 0;

        for(int i = 0; i < n; i++) {
            coffeeMachine.add(new Coffee(i,coffee_times[i]));
            index++;
        }

        System.out.println("index의 시작은 " + index);

        while(complete.size() != coffee_times.length) {

            // round 진행
            for (Coffee c : coffeeMachine) {
                c.time = c.time -1;
                System.out.println("index : " + (c.index+1) + ", time : " + c.time);
            }

            // 끝난 커피 가져오기 + 채우기
            List<Coffee> remove = new ArrayList<>();
            for (Coffee c : coffeeMachine) {
                if(c.time == 0) {
                    complete.add(c.index+1);
                    remove.add(c);
                    System.out.println("완료추가 : " + (c.index+1));
                }
            }

            for(Coffee c : remove) {
                coffeeMachine.remove(c);
                System.out.println("삭제완료 : " + c.index);
                if(index <= coffee_times.length -1) {
                    coffeeMachine.add(new Coffee(index, coffee_times[index]));
                    index++;
                }
            }

        }



        return complete.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Coffee {
        private int index;
        private int time;

        Coffee(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

    static int[] solution(int n, int[] coffee_times) {
        // 커피추출 완료된 List
        List<Integer> complete = new ArrayList<>(coffee_times.length);

        // 커피머신Map
        Map<Integer, Integer> coffeeMachineMap = new HashMap<>();

        // 커피머신에 넣은 최근 인덱스
        int index = 0;

        // 초기셋팅
        for (int i = 0; i < n; i++) {
            coffeeMachineMap.put(i, coffee_times[i]);
            index++;
        }

        while (complete.size() != coffee_times.length) {
            for (Map.Entry<Integer, Integer> entry : coffeeMachineMap.entrySet()) {
                coffeeMachineMap.put(entry.getKey(), entry.getValue() - 1);
            }

            List<Integer> remove = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : coffeeMachineMap.entrySet()) {
                if (entry.getValue() == 0) {
                    System.out.println("완료 Index : " + entry.getKey());
                    complete.add(entry.getKey() + 1);
                    remove.add(entry.getKey());
                }
            }

            for (int r : remove) {
                coffeeMachineMap.remove(r);
                if (index <= coffee_times.length - 1) {
                    coffeeMachineMap.put(index , coffee_times[index]);
                    index++;
                }
            }
        }
        return complete.stream().mapToInt(Integer::intValue).toArray();
    }
}

//    문제 설명
//    한 번에 최대 N 잔까지 동시에 커피를 추출할 수 있는 커피 추출기가 있습니다. 이 커피 추출기를 이용해 커피를 만들 때, 커피가 만들어지는 순서를 구하려 합니다.
//
//        만들어야 하는 커피가 M잔이면, 커피에 1부터 M까지 순서대로 주문번호가 붙어있습니다. 또, 주문번호 순으로 빈 커피 추출구에서 커피를 만들기 시작합니다. 만약 빈 추출구가 없다면, 빈 추출구가 생길 때까지 다음 주문은 잠시 기다리며, 빈 추출구가 생기면 대기 중인 다음 커피를 즉시 만들기 시작합니다.
//
//        모든 커피는 만드는데 일정 시간이 소요되는데, 소요 시간은 커피 종류별로 다를 수 있습니다. 따라서 커피 제조 시간에 따라 각 주문이 완료되는 순서는 다를 수 있습니다.
//
//        커피 추출구 개수 N, 각 커피를 만드는데 걸리는 시간이 주문번호 순서대로 담긴 배열 coffee_times가 매개변수로 주어질 때, 커피가 완성되는 순서대로 주문번호를 배열에 담아 return 하도록 solution 함수를 완성해주세요.
//
//        단, 커피 주문이 추출구에 배정되는데 걸리는 시간은 없다고 가정하며, 커피 추출이 동시에 완료됐을 경우 작은 주문번호가 앞에 오도록 하면 됩니다.
//
//        제한사항
//        N은 1 이상 10,000 이하인 자연수입니다.
//        coffee_times의 길이는 1 이상 300,000 이하입니다.
//        coffee_times의 원소는 1 이상 100,000,000 이하인 자연수입니다.
//        입출력 예
//        N	coffee_times	result
//        3	[4, 2, 2, 5, 3]	[2, 3, 1, 5, 4]
//        1	[100, 1, 50, 1, 1]	[1, 2, 3, 4, 5]
//        입출력 예 설명
//        입출력 예 #1
//
//        커피 추출구 개수 N = 3이고, 커피별 제조시간은 주문 번호 순서대로 [ 4초, 2초, 2초, 5초, 3초]입니다.
//
//        시간(초)	제작중 커피(주문 번호)	완료 순서
//        0	[1번, 2번, 3번]	[]
//        1	[1번, 2번, 3번]	[]
//        2	[1번, 4번, 5번]	[2번, 3번]
//        3	[1번, 4번, 5번]	[2번, 3번]
//        4	[4번, 5번]	[2번, 3번, 1번]
//        5	[4번]	[2번, 3번, 1번, 5번]
//        6	[4번]	[2번, 3번, 1번, 5번]
//        7	[]	[2번, 3번, 1번, 5번, 4번]
//        빈 추출구 3곳에 1, 2, 3번 주문이 동시에 배정됩니다.
//        2초가 지나면 2, 3번 커피가 다 만들어지고, 빈 추출구에 4, 5번 주문이 배정됩니다.
//        4초가 지나면 1번 커피가 완료되며, 5번 주문이 배정됩니다.
//        배정 후 3초가 지난 5초에 5번 주문이 완료됩니다.
//        배정 후 5초가 지난 7초에 4번 주문이 완료됩니다.
//        따라서 [2, 3, 1, 5, 4]를 return 하면 됩니다.
//
//        입출력 예 #2
//        커피 추출구 개수 N = 1이므로, 한 번에 한 잔씩 커피를 만들 수 있습니다. 따라서 커피는 주문번호 순서대로 완성됩니다.
