import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class BOJ13305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] distance = new int[N-1];
        int [] price = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i <N-1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * 문제 조건를 보고 자료형 잘 결정하자
         */
        
        long answer = 0;
        long sumdistance = 0;
        long nowPrice = 0;

        boolean [] visited = new boolean[N-1];

        for(int i=0; i<N-1; i++){
            if(visited[i]){
                continue;
            }

            sumdistance+= distance[i];
            nowPrice = price[i];

            for(int j=i+1; j<N-1; j++){
                if(nowPrice > price[j]){
                    break;
                }
                else{
                    visited[j] = true;
                    sumdistance += distance[j];
                }
            }

            answer += sumdistance *nowPrice;
            sumdistance =0;
        }

        System.out.println(answer);
    }
}
