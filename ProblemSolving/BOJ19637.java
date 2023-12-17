import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ19637 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        String[] name = new String[n];
        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            name[i] = temp[0];
            score[i] = Integer.parseInt(temp[1]);
        }

        StringBuilder sb = new StringBuilder
            ();

        for (int i = 0; i < m; i++) {
            int val = Integer.parseInt(br.readLine());
            int start = 0;
            int end = n - 1;
            int mid = 0;
            while (start <= end) {
                mid = (start + end) / 2;

                if (score[mid] < val) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            sb.append(name[start] + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}
