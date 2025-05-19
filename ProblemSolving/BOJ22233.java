package _BOJPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ22233 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for(int i=0; i<N; i++) {
            set.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<len; i++) {
             st = new StringTokenizer(br.readLine(), ",");
             while(st.hasMoreTokens()) {
                 set.remove(st.nextToken());
             }
            sb.append(set.size()+"\n");
        }
        System.out.println(sb);
    }
}
