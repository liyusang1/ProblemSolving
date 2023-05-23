import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Programmers07 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        Deque<String> queue1 = new ArrayDeque<>();
        Deque<String> queue2 = new ArrayDeque<>();

        for (String i : cards1) {
            queue1.add(i);
        }

        for (String i : cards2) {
            queue2.add(i);
        }

        for (String i : goal) {
            if (queue1.size() != 0 && queue1.getFirst().equals(i)) {
                queue1.removeFirst();
            } else if (queue2.size() != 0 && queue2.getFirst().equals(i)) {
                queue2.removeFirst();
            } else {
                answer = "No";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers07 test = new Programmers07();
        System.out.println(test.solution(new String[]{"i", "drink", "water"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}));

        System.out.println(test.solution(new String[]{"i", "water", "drink"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}));

    }
}
