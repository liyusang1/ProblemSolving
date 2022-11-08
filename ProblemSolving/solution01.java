import java.util.Deque;
import java.util.LinkedList;

public class solution01 {
    public static String solution(int[] food) {

        Deque<Integer> deque = new LinkedList();
        Deque<Integer> deque2 = new LinkedList();

        for (int i = 1; i < food.length; i++) {
            if (food[i] < 2) {
                continue;
            }
            while (food[i] >= 2) {
                deque.addLast(i);
                deque2.addFirst(i);
                food[i] -= 2;
            }
        }

        String answer = "";

        for (int i : deque) {
            answer += i;
        }
        answer += "0";
        for (int i : deque2) {
            answer += i;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 6}));
        System.out.println(solution(new int[]{1, 7, 1, 2}));

        int[] arr = {1, 2, 3, 4};
    }
}
