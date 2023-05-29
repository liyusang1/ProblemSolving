import java.util.ArrayDeque;
import java.util.Deque;

public class Programmers14 {

    public String solution(int[] food) {
        String answer = "";

        Deque<String> first = new ArrayDeque<>();
        Deque<String> last = new ArrayDeque<>();

        for (int i = 1; i < food.length; i++) {

            for (int j = 0; j < food[i] / 2; j++) {
                first.addLast(Integer.toString(i));
                last.addFirst(Integer.toString(i));
            }
        }

        for (String i : first) {
            answer += i;
        }
        answer += "0";
        for (String i : last) {
            answer += i;
        }

        return answer;
    }


    public static void main(String[] args) {

        Programmers14 test = new Programmers14();
        System.out.println(test.solution(new int[]{1, 3, 4, 6}));
        System.out.println(test.solution(new int[]{1, 7, 1, 2}));

    }
}
