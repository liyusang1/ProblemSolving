package _BOJPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO DP 정석문제 추후 다시생각해보기
public class BOJ11660 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];

        int[][] target = new int[M][4];
        int[] answer = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                target[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][N - 1] + arr[i][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + arr[i][j];
                }
            }
        }

        int[] start = new int[2];
        int[] end = new int[2];

        for (int i = 0; i < M; i++) {
            start[0] = target[i][0] - 1;
            start[1] = target[i][1] - 1;
            end[0] = target[i][2] - 1;
            end[1] = target[i][3] - 1;

            for (int j = start[0]; j <= end[0]; j++) {
                int temp = start[1] - 1;
                if (temp < 0) {
                    if (j == 0) {
                        answer[i] += dp[j][end[1]];
                    } else {
                        answer[i] += dp[j][end[1]] - dp[j - 1][N - 1];
                    }
                } else {
                    temp = dp[j][start[1] - 1];
                    answer[i] += dp[j][end[1]] - temp;
                }
            }
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }
}

/*
4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
3 4 3 4
1 1 4 4
->27 6 64

4 1
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
1 1 4 4
*/
