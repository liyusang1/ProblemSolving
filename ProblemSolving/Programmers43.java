import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Programmers43 {
    public long solution(long n) {
        String[] temp = String.valueOf(n).split("");
        Arrays.sort(temp);
        StringBuilder answer = new StringBuilder();

        for (String i : temp) {
            answer.append(i);
        }

        return Long.parseLong(answer.reverse().toString());
    }

    public static void main(String[] args) {

        Programmers43 test = new Programmers43();
        System.out.println(test.solution(6));
        System.out.println(test.solution(16));
        System.out.println(test.solution(626331));
    }
}
