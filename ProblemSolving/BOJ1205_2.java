import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1205 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int len = Integer.parseInt(st.nextToken());
        int myScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken()); //랭킹에 올라갈 수 있는 max

        if(len!=0) {
            st = new StringTokenizer(br.readLine(), " ");
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

        for (int i = 0; i < len; i++) {
            if (priorityQueue.size() == p) {
                priorityQueue.poll();
            }
            priorityQueue.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 1;

        if (priorityQueue.size() == p) {
            if (priorityQueue.peek() < myScore) {
                priorityQueue.poll();
            } else {
                answer = -1;
            }
        }

        if (answer != -1) {
            priorityQueue.add(myScore);
            PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Comparator.reverseOrder());

            priorityQueue2.addAll(priorityQueue);

            while (!priorityQueue2.isEmpty()) {
                int temp = priorityQueue2.poll();
                if (temp == myScore) {
                    break;
                }
                answer++;
            }

            System.out.println(answer);
        }
        else{
            System.out.println(answer);
        }
    }
}
