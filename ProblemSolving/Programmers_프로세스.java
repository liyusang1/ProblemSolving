import java.util.*;

public class Programmers_프로세스 {
    public int solution(int[] priorities, int location) {
        int[] answer = new int[priorities.length];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            priorityQueue.add(priorities[i]);
            queue.add(new int[]{priorities[i], i});
        }

        int count = 1;
        while (!priorityQueue.isEmpty()) {

            int[] temp = queue.peek();

            if (priorityQueue.peek() == temp[0]) {
                answer[temp[1]] = count++;
                priorityQueue.remove();
                queue.remove();
                
            } else {
                queue.add(queue.remove());
            }
        }

        return answer[location];
    }

    public static void main(String[] args) {
        Programmers_프로세스 test = new Programmers_프로세스();
        System.out.println((test.solution(new int[]{2, 1, 3, 2}, 2)));
        System.out.println((test.solution(new int[]{1, 1, 9, 1, 1, 1}, 0)));
    }
}

