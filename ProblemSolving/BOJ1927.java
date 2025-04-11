package _0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1927 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                if (priorityQueue.isEmpty()) {
                    stringBuilder.append(0 + "\n");
                } else {
                    int num = priorityQueue.poll();
                    stringBuilder.append(num + "\n");
                }

            } else {
                priorityQueue.add(temp);
            }
        }

        System.out.println(stringBuilder);
    }
}
