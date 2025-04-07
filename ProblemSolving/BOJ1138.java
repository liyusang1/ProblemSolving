package _0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        List<Integer> result = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            System.out.println("arr[i]  : " + arr[i]);
            System.out.println("i : " + i );

            result.add(arr[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int su : result) {
            sb.append(su).append(" ");
        }

        System.out.println(sb);

    }
}


/*
4
2 1 1 0

3 2 1 0

4 3 2 0


4 2 1 3
* */
