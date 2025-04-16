package _0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2531 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수

        int[] counts; //초밥의 가짓수 저장하는 배열

        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
        int couponNum = Integer.parseInt(st.nextToken()); //쿠폰번호

        int[] arr = new int[N]; //초밥저장

        for (int i = 0; i < N; i++) {
            arr[i] = (Integer.parseInt(br.readLine()));
        }

        int max = -1;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            temp = 0;
            counts = new int[3001];

            for (int j = i; j < i + k; j++) {
                int cur = j;
                if (j >= arr.length) {
                    cur = j - arr.length;
                }
                if (counts[arr[cur]] >= 1) {
                } else {
                    counts[arr[cur]]++;
                    temp++;
                }
            }

            if (counts[couponNum] == 0) {
                temp++;
            }

            max = Math.max(max, temp);
        }
        System.out.println(max);
    }
}

/*
5 50 3 2
5
5
2
5
5

# 1
2 9 1 1
2
1

ans: 2


# 2
3 9 3 1
2
3
4

ans: 4

8 30 4 30
7
7
3
7
7
8
7
7

->4
*/
