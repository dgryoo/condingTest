package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Hash01 {

//    participant	completion	return
//            ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
//            ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
//            ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"


    public static void main(String[] args) {


        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String result = "mislav";

        if (result == solution(participant, completion)) System.out.println("true");
        ;


    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> resultMap = new HashMap<>();

        for (String p : participant) {
            if (resultMap.containsKey(p)) {
                resultMap.put(p, resultMap.get(p) + 1);
            } else {
                resultMap.put(p, 1);
            }
        }

        for (String c : completion) {
            if (resultMap.get(c) > 1) {
                resultMap.put(c, resultMap.get(c) - 1);
            } else {
                resultMap.remove(c);
            }
        }

        return resultMap.keySet().iterator().next();

    }

}
