import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers13 {

    public int solution(int k, int m, int[] score) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : score) {
            queue.add(i);
        }

        while (queue.size() >= m) {
            for (int i = 0; i < m - 1; i++) {
                queue.remove();
            }
            answer += queue.peek() * m;
            queue.remove();
        }

        return answer;
    }


    public static void main(String[] args) {

        Programmers13 test = new Programmers13();
        System.out.println(test.solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
        System.out.println(test.solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));

    }
}
