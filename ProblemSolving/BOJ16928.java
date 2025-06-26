package _BOJPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TODO DP로 못푸는 문제 DP로 풀기위해서는 필요한 정보가 모두 결정되어 있어야 하지만 아래 같은 예시는 최적의 해가 나중에 갱신되기때문에
//다시풀어보기
//2 1
//
//5 80
//
//81 30
//
//31 99
public class BOJ16928 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N + K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(a, b);
        }

        boolean[] visited = new boolean[101];
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        outerLoop:
        while (!q.isEmpty()) {
            cnt++;
            for (int i = 0, qSize = q.size(); i < qSize; i++) {
                int now = q.poll();

                for (int j = 1; j <= 6; j++) {
                    int move = now + j;
                    if (move == 100) break outerLoop;

                    if (move > 100) continue;
                    if (visited[move]) continue;

                    visited[move] = true;
                    if (map.containsKey(move)) {
                        move = map.get(move);
                    }
                    q.add(move);
                }
            }
        }

        System.out.println(cnt);
    }
}

/*

1 1
5 88
94 90

-> 4

2 1
5 80
31 99
81 30
->4
 */
