import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1205 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int taesoo = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] score = new int[P];
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                score[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(score);

        if (P == N && score[0] >= taesoo) {
            System.out.println(-1);
            return;
        }

        int cnt = 1;
        for (int i = P - 1; i >= Math.max(0, P - N - 1); i--) {
            if (score[i] > taesoo) {
                cnt++;
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }
}
