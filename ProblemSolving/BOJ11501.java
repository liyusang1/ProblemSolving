package _0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TODO 2중포문 시간초과

public class BOJ11501 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            long currentProfit = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] stock = new int[n];

            for (int j = 0; j < n; j++) {
                stock[j] = Integer.parseInt(st.nextToken());
            }

            //TODO :: 역순아이디어..
            int max = Integer.MIN_VALUE;
            for(int j = stock.length-1; j >=0; j--) {
                if(stock[j] > max) {
                    max = stock[j];
                } else{
                    currentProfit += max-stock[j];
                }
            }

            ans.append(currentProfit).append("\n");
        }
        System.out.println(ans);
    }
}

/*
3
3
10 7 6
3
3 5 9
5
1 1 3 1 2
*/

/*
1
5
0 3 5 3 2   -> 7
*/