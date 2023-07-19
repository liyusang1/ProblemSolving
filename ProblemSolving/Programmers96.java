import java.util.*;
//프로그래머스 다리를 지나는 트럭
public class Programmers96 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Deque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        Queue<Integer> truck = new LinkedList<>();
        for (int i : truck_weights) {
            truck.add(i);
        }

        int sum = 0;
        while (true) {
            if (sum == 0 && truck.isEmpty()) {
                break;
            }
            if (!truck.isEmpty() && sum + truck.peek() <= weight) {
                sum += truck.peek();
                bridge.addLast(truck.remove());
                int temp = bridge.removeFirst();
                sum -= temp;

            } else {
                int temp = bridge.removeFirst();
                sum -= temp;
                if (!truck.isEmpty() && sum + truck.peek() <= weight) {
                    sum += truck.peek();
                    bridge.addLast(truck.remove());
                } else {
                    bridge.addLast(0);
                }
            }
            answer++;
        }


        return answer;
    }

    public static void main(String[] args) {

        Programmers96 test = new Programmers96();
        System.out.println((test.solution(2, 10, new int[]{7, 4, 5, 6})));
        System.out.println((test.solution(100, 100, new int[]{10})));
        System.out.println((test.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10})));
    }
}

