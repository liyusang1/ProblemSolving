package _BOJPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//TODO maxmin 값 설정할때 integer.max,int 로 설정하자 그렇게 설정하지 않아 틀린문제

public class BOJ2096 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        int[][] maxDp = new int[N][3];
        int[][] minDp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            maxDp[0][i] = arr[0][i];
            minDp[0][i] = arr[0][i];
        }

        //mindp 초기화
        for (int i = 1; i < N; i++) {
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i < N; i++) {
            //max
            maxDp[i][0] = Math.max(maxDp[i][0], maxDp[i - 1][0] + arr[i][0]);
            maxDp[i][0] = Math.max(maxDp[i][0], maxDp[i - 1][1] + arr[i][0]);

            maxDp[i][1] = Math.max(maxDp[i][1], maxDp[i - 1][0] + arr[i][1]);
            maxDp[i][1] = Math.max(maxDp[i][1], maxDp[i - 1][1] + arr[i][1]);
            maxDp[i][1] = Math.max(maxDp[i][1], maxDp[i - 1][2] + arr[i][1]);

            maxDp[i][2] = Math.max(maxDp[i][2], maxDp[i - 1][1] + arr[i][2]);
            maxDp[i][2] = Math.max(maxDp[i][2], maxDp[i - 1][2] + arr[i][2]);

            //min
            minDp[i][0] = Math.min(minDp[i][0], minDp[i - 1][0] + arr[i][0]);
            minDp[i][0] = Math.min(minDp[i][0], minDp[i - 1][1] + arr[i][0]);

            minDp[i][1] = Math.min(minDp[i][1], minDp[i - 1][0] + arr[i][1]);
            minDp[i][1] = Math.min(minDp[i][1], minDp[i - 1][1] + arr[i][1]);
            minDp[i][1] = Math.min(minDp[i][1], minDp[i - 1][2] + arr[i][1]);

            minDp[i][2] = Math.min(minDp[i][2], minDp[i - 1][1] + arr[i][2]);
            minDp[i][2] = Math.min(minDp[i][2], minDp[i - 1][2] + arr[i][2]);
        }

        int max = -1;
        int min = Integer.MAX_VALUE;

        for (int i : maxDp[N - 1]) {
            max = Math.max(max, i);
        }
        for (int i : minDp[N - 1]) {
            min = Math.min(min, i);
        }

        System.out.println(max + " " + min);
    }
}

/*
3
1 2 3
4 5 6
4 9 0
-> 18,6

2
1 10 1
2 1 1

5
1 2 3
4 5 6
7 8 9
0 0 0
4 9 2
*/