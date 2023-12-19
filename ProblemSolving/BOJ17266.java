import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17266 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int[] array = new int[a];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                min = array[i];
            } else {
                int i1 = (array[i] - array[i - 1]) / 2;
                if ((array[i] - array[i - 1]) % 2 != 0) {
                    i1 += 1;
                }
                min = Math.max(i1, min);
            }
        }

        min = Math.max(N - array[array.length - 1], min);

        System.out.println(min);
    }
}
