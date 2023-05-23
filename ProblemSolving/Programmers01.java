import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers01 {
    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String i : callings) {

            int cur = map.get(i);

            map.put(i, cur - 1);
            map.put(players[cur - 1], cur);

            players[cur] = players[cur - 1];
            players[cur - 1] = i;
        }

        return players;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine"})));

    }
}
