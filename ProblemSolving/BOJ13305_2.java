package _BOJPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13305 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int[] distance = new int[x - 1];
        int[] price = new int[x];

        Long answer = 0L;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < x - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < x; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        answer += (long) distance[0] * price[0];

        int min = price[0];

        for (int i = 1; i < x - 1; i++) {
            if(price[i] < min){
                min = price[i];
            }
            answer += (long) min * distance[i];
        }

        System.out.println(answer);
    }
}
