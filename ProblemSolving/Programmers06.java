import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers06 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int n = 0; n < targets.length; n++) {

            Map<Character, Integer> map = new HashMap<>();

            for (int j = 0; j < targets[n].length(); j++) {
                map.put(targets[n].charAt(j), 1000);
            }

            boolean check = true;
            for (int i = 0; i < targets[n].length(); i++) {
                for (String j : keymap) {
                    for (int k = 0; k < j.length(); k++) {
                        if (j.charAt(k) == targets[n].charAt(i)) {
                            check = true;
                            break;
                        } else {
                            check = false;
                        }
                    }
                    if (check) {
                        break;
                    }
                }
                if (!check) {
                    answer[n] = -1;
                    break;
                }
            }
            if (!check){
                continue;
            }

            for (String str : keymap) {
                for (int i = 0; i < str.length(); i++) {
                    if (map.containsKey(str.charAt(i))) {
                        map.put(str.charAt(i), Math.min(map.get(str.charAt(i)), i + 1));
                    }
                }
            }

            int sum = 0;
            for (int i = 0; i < targets[n].length(); i++) {
                sum += map.get(targets[n].charAt(i));
            }
            answer[n] = sum;
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers06 test = new Programmers06();
        System.out.println(Arrays.toString(test.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"})));
        System.out.println(Arrays.toString(test.solution(new String[]{"AA"}, new String[]{"BB"})));
        System.out.println(Arrays.toString(test.solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA", "BGZ"})));
        System.out.println(Arrays.toString(test.solution(new String[]{"BC"}, new String[]{"AC", "BC"})));

    }
}
