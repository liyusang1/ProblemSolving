import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
//프로그래머스 더 맵게

public class Programmers93 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i : scoville) {
            priorityQueue.add(i);
        }

        while (true) {
            if (priorityQueue.size() <= 1) {
                break;
            } else if (priorityQueue.peek() >= K) {
                break;
            }

            int number1 = priorityQueue.remove();
            int number2 = priorityQueue.remove();

            priorityQueue.add(number1 + (number2 * 2));
            answer++;
        }

        for(int i : priorityQueue){
            if (i < K){
                return -1;
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        Programmers93 test = new Programmers93();
        System.out.println(test.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}

