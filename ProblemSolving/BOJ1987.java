package _BOJPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ1987 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Character[][] arr = new Character[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = (line.charAt(j)); // 각 문자를 String으로 저장
            }
        }

        boolean[][] visited = new boolean[N][M];
        boolean[] alphabet = new boolean[26];

        DFS(arr, visited, 0, 0, alphabet, 0);
        System.out.println(max);
    }

    public static void DFS(Character[][] arr, boolean[][] visited, int i, int j, boolean[] alphabet, int len) {
        max = Math.max(len, max);
        visited[i][j] = true;
        alphabet[(int) arr[i][j] - (int) 'A'] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || visited[x][y]) {
                continue;
            } else {
                int temp = (int) arr[x][y] - (int) 'A';
                if (alphabet[temp]) {
                    continue;
                } else {
                    DFS(arr, visited, x, y, alphabet, len + 1);
                    //TODO 재귀로 방문 후 다시 돌아가는게 핵심
                    visited[x][y] = false;
                    alphabet[temp] = false;
                }
            }
        }

    }
}

/*
2 4
CAAB
ADCB

3 6
HFDFFB
AJHGDH
DGAGEH

5 5
IEFCJ
FHFKC
FFALF
HFGCF
HMCHH
*/
