import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14502 {

    static int[][] copyArr;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        copyArr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(arr,0);
        System.out.println(max);
    }

    //TODO DFS를 활용해서 모든 경우의 수를 찾는 것이 핵심
    public static void DFS(int[][] arr,int wallCount) {
        if (wallCount == 3) {
            DFS2(arr);
            return;
        }

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                if(arr[i][j]==0) {
                    arr[i][j] = 1;
                    DFS(arr,wallCount+1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void DFS2(int[][] arr) {
        for (int k = 0; k < arr.length; k++) {
            copyArr[k] = arr[k].clone();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 2) {
                    DFS3(i, j);
                }
            }
        }
        max = Math.max(getSafeZone(copyArr), max);
    }

    public static void DFS3(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || x >= copyArr.length || y < 0 || y >= copyArr[0].length || copyArr[x][y] != 0) {
                continue;
            } else {
                copyArr[x][y] = 2;
                DFS3(x, y);
            }
        }
    }

    public static int getSafeZone(int[][] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    temp++;
                }
            }
        }
        return temp;
    }
}

/*

4 6
0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2

*/