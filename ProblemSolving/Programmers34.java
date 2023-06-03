import java.util.HashMap;
import java.util.Map;

public class Programmers34 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for (String i : participant) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (String i : completion) {
            map.put(i, map.get(i) - 1);
        }

        for (String i : map.keySet()) {
            if (map.get(i) != 0) {
                return i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Programmers34 test = new Programmers34();
        System.out.println(test.solution(new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}));
        System.out.println(test.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(test.solution(new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}));
    }
}
