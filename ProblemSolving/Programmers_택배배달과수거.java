import java.util.*;

public class Programmers_택배배달과수거 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delivery = 0;
        int pickup = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] == 0 && pickups[i] == 0) {
                continue;
            }

            int cnt = 0;
            while (delivery < deliveries[i] || pickup < pickups[i]) {
                delivery += cap;
                pickup += cap;
                cnt++;
            }
            answer += (i + 1) * cnt * 2;
            delivery -= deliveries[i];
            pickup -= pickups[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_택배배달과수거 test = new Programmers_택배배달과수거();
        System.out.println((test.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0})));
    }
}

