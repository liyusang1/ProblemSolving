import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Programmers11 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> queue = new PriorityQueue();
        queue.add(score[0]);
        int count = 1;
        answer[0] = score[0];

        for (int i = 1; i < score.length; i++) {
            if (count < k) {
                queue.add(score[i]);
            } else {
                if (score[i] > queue.peek()) {
                    queue.remove();
                    queue.add(score[i]);
                }
            }
            answer[i] = queue.peek();
            count += 1;
        }

        return answer;
    }


    public static void main(String[] args) {

        Programmers11 test = new Programmers11();
        System.out.println(Arrays.toString(test.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));;
    }
}
