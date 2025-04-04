import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10431 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        int[][] arr = new int[len][20];

        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int temp = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 20; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            res[i][0] = i + 1;

            for (int j = 1; j < 20; j++) {
                for (int k = 0; k < j; k++) {

                    if (arr[i][k] > arr[i][j]) {
                        int temp = arr[i][k];
                        arr[i][k] = arr[i][j];
                        arr[i][j] = temp;
                        res[i][1] += 1;
                    }
                }
            }

        }

        for (int i = 0; i < len; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
}
