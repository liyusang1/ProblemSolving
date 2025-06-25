package _BOJPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940 {
    static int[][] ans;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        ans = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                ans[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (graph[i][j] == 2) {
                    ans[i][j] = 0;
                    BFS(graph, i, j);
                    break;
                }
            }
        }

        // 출력 부분 최적화
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                if(ans[i][j] == -1 && graph[i][j] == 0){
                    ans[i][j] = 0;
                }
                sb.append(ans[i][j]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    static void BFS(int[][] graph, int i, int j) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        int[] x = new int[]{0, -1, 0, 1};
        int[] y = new int[]{-1, 0, 1, 0};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + x[k];
                int ny = cur[1] + y[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && ans[nx][ny]==-1 && graph[nx][ny] != 0) {
                    ans[nx][ny] = ans[cur[0]][cur[1]] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}