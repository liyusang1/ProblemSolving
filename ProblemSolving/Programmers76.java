import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Programmers76 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        Map<String, Integer> checkMap = new HashMap(map);

        for (int i = 0; i < discount.length; i++) {
            for (int k = i; k < i + 10; k++) {
                if (k > discount.length - 1) {
                    break;
                }
                if (checkMap.containsKey(discount[k])) {
                    checkMap.put(discount[k], checkMap.get(discount[k]) - 1);
                }
            }
            boolean check = true;
            for (String string : checkMap.keySet()) {
                if (checkMap.get(string) > 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                answer++;
            }
            checkMap = new HashMap<>(map);
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers76 test = new Programmers76();
        System.out.println(test.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}
                , new int[]{3, 2, 2, 2, 1}
                , new String[]{"chicken", "apple", "apple", "banana", "rice", "apple",
                        "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));

    }
}
