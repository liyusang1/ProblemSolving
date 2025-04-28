package _BOJPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int index = 0;
            while (st.hasMoreTokens()) {
                arr[i][index++] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + arr[i][j], dp[i][j]);
                if (j + 1 < N) {
                    dp[i][j + 1] = Math.max(dp[i - 1][j] + arr[i][j + 1], dp[i][j + 1]);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[N - 1][i]);
        }

        System.out.println(max);
    }
}

/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5

*/