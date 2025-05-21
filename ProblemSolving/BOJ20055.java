package _BOJPS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20055 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N * 2];
        int[] robot = new int[N];

        int zeroCount = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 0) {
                zeroCount++;
            }
        }

        int answer = 0;
        while (zeroCount < K) {

            int lastValue = arr[N * 2 - 1];

            for (int i = N * 2 - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = lastValue;

            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = 0;
            robot[N - 1] = 0;

            // 2. 로봇 이동
            for (int i = N - 1; i > 0; i--) {
                if (robot[i - 1] == 1 && robot[i] == 0 && arr[i] > 0) {
                    robot[i] = 1;
                    robot[i - 1] = 0;
                    arr[i]--;
                    if (arr[i] == 0) {
                        zeroCount++;
                    }
                }
            }

            if (arr[0] != 0) {
                robot[0] = 1;
                arr[0]--;
                if (arr[0] == 0) {
                    zeroCount++;
                }
            }
            answer++;
        }

        System.out.println(answer);
    }
}
