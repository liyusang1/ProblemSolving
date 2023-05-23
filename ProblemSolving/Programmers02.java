import java.util.*;

public class Programmers02 {

    public List solution(String[] name, int[] yearning, String[][] photo) {

        List answer = new ArrayList();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (String[] i : photo) {
            int sum = 0;
            for (String j : i) {
                if (map.containsKey(j)) {
                    sum += map.get(j);
                }
            }
            answer.add(sum);
        }

        return answer;
    }


    public static void main(String[] args) {

        Programmers02 test1 = new Programmers02();
        System.out.println(test1.solution(
                new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3},
                new String[][]{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}}
        ));

    }
}
