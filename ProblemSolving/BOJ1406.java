package _0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        int N = Integer.parseInt(br.readLine());

        Deque<String> deque1 = new ArrayDeque<>(Arrays.asList(arr));
        Deque<String> deque2 = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            String order = "";
            String keyword = "";

            if (temp.length() == 1) {
                order = temp;
            } else {
                order = temp.split(" ")[0];
                keyword = temp.split(" ")[1];
            }

            if (order.equals("L")) {
                if (!deque1.isEmpty()) {
                    deque2.addFirst(deque1.pollLast());
                }
            } else if (order.equals("D")) {
                if (!deque2.isEmpty()) {
                    deque1.addLast(deque2.pollFirst());
                }
            } else if (order.equals("B")) {
                if (!deque1.isEmpty()) {
                    deque1.removeLast();
                }
            } else if (order.equals("P")) {
                deque1.addLast(keyword);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!deque1.isEmpty()) {
            ans.append(deque1.pollFirst());
        }

        while (!deque2.isEmpty()) {
            ans.append(deque2.pollFirst());
        }

        System.out.println(ans);
    }
}
