import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7568 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st.nextToken());

        int [] result = new int[len];
        Arrays.fill(result, 1);
        int [][] arr = new int[len][2];

        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken()); //몸무게
            int y = Integer.parseInt(st.nextToken()); //키

            arr[i][0] = x;
            arr[i][1] = y;
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(i==j){
                    continue;
                }
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    result[i] ++;
                }
            }
        }

        for(int i = 0; i < len; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
