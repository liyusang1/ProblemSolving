package _BOJPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                } else if (j == 1) {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                } else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N - 1][i]);
        }

        System.out.println(min);
    }
}

/*
3
26 40 83
49 60 57
13 89 99

3
1 100 100
100 1 100
100 100 1

6
30 19 5
64 77 64
15 19 97
4 71 57
90 86 84
93 32 91
-> 208
* */