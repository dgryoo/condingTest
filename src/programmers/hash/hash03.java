package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class hash03 {

    public static void main(String[] args) {

        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"yellowhat", "headgear"}, {"bluesunglasses", "headgear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes2));

        System.out.println(solution2(clothes2));

    }

    static int solution(String[][] clothes) {
        int method = 1;

        Map<String, Integer> clothesMap = new HashMap();

        for (int i = 0; i < clothes.length; i++) {
            String recentItem = clothes[i][1];
            if (!clothesMap.containsKey(recentItem)) {
                clothesMap.put(recentItem, 1);
            } else {
                clothesMap.put(recentItem, clothesMap.get(recentItem) + 1);
            }
        }

        if(clothesMap.size() == 1) {
            System.out.println("아이템이 하나입니다");
            return method * clothesMap.get(clothes[0][1]);
        }

        Iterator<Integer> iterator = clothesMap.values().iterator();
        while(iterator.hasNext()) {
            int recentValue = iterator.next() + 1;
            System.out.println(recentValue);
            method = method * recentValue;
        }
        return method - 1;
    }

    static int solution2(String[][] clothes) {

        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            if(!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext()) {
            int a = it.next();
            System.out.println(a+1);
            answer *= a+1;
        }
        return answer-1;

    }
}
