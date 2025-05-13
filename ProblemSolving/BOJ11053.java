package _BOJPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO DP 문제
public class BOJ11053 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int [] dp = new int[N];
        Arrays.fill(dp, 1);

        for(int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                if(arr[j]>arr[i]) {
                    dp[j] = Math.max(dp[j], dp[i]+1);
                }
            }
        }

        int max = -1;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}

/*
 input:
4
1 10 2 3
output:
2
answer:
3

1 2 2 3


10 20 10 30 20 50


1 2 1 3 2 3


*/