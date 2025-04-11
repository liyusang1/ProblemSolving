package _0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//TODO : 구현아이디어가 중요
public class BOJ2304 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparing(o -> o[0]));
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < N; i++) {
            if (max < arr[i][1]) {
                max = arr[i][1];
                maxIndex = i;
            }
        }

        int height = arr[0][1];
        int left = 0;

        for (int i = 0; i < maxIndex; i++) {
            if (height < arr[i][1]) {
                height = arr[i][1];
            }
            left += (arr[i + 1][0] - arr[i][0]) * height;
        }

        height = arr[N - 1][1];
        int right = 0;

        for (int i = N - 1; i > maxIndex; i--) {
            if (height < arr[i][1]) {
                height = arr[i][1];
            }
            right += (arr[i][0] - arr[i-1][0]) * height;
        }

        int middle = max;
        System.out.println((left + middle + right));
    }
}
