import java.util.*;

public class Programmers_할인행사 {
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
}

