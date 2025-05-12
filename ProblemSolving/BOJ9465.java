package _BOJPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO dp 경우의 수 다시 생각해보기 1번선택하고 2번아예 선택하지 않고 3번 선택하는 경우 고려해야함

public class BOJ9465 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {

            int len = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][len];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < len; j++) {
                arr[0][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < len; j++) {
                arr[1][j] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[2][len];

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            for (int j = 1; j < len; j++) {

                dp[0][j] = Math.max(dp[0][j], dp[1][j - 1] + arr[0][j]);
                dp[1][j] = Math.max(dp[1][j], dp[0][j - 1] + arr[1][j]);

                if (j < len - 1) {
                    dp[0][j + 1] = Math.max(dp[0][j + 1], dp[0][j - 1] + arr[0][j + 1]);
                    dp[0][j + 1] = Math.max(dp[0][j + 1], dp[1][j - 1] + arr[0][j + 1]);
                    dp[1][j + 1] = Math.max(dp[1][j + 1], dp[0][j - 1] + arr[1][j + 1]);
                    dp[1][j + 1] = Math.max(dp[1][j + 1], dp[1][j - 1] + arr[1][j + 1]);
                }
            }

       /*     for (int[] k : dp) {
                System.out.println(Arrays.toString(k));
            }*/

            int max = Math.max(dp[0][len - 1], dp[1][len - 1]);
            answer[i] = max;
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }
}


/*
1
5
50 10 100 20 40
30 50 70 10 60

50 10 100 20 40
30 50 70 10 60

1
5
10 1 1 1 10
1 1 10 1 1
-> 30

1
5
2 1 1 2 1
1 3 2 1 2
->9
*/