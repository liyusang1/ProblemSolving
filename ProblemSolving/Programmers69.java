import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers69 {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> count = new HashMap<>();

        for (int i : weights) {
            double a = i * 1.0;
            double b = (i * 1.0) / 2.0;
            double c = (i * 2.0) / 3.0;
            double d = (i * 3.0) / 4.0;

            if (count.containsKey(a))
                answer += count.get(a);
            if (count.containsKey(b))
                answer += count.get(b);
            if (count.containsKey(c))
                answer += count.get(c);
            if (count.containsKey(d))
                answer += count.get(d);

            count.put((i * 1.0), count.getOrDefault((i * 1.0), 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers69 test = new Programmers69();
        System.out.println(test.solution(new int[]{100, 180, 360, 100, 270}));
    }
}
