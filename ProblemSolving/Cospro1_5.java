import java.util.Arrays;

class Cospro1_5 {
    public void solution(int n) {

        int[][] answer = new int[n][n];
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        int turn = (n % 2 == 0) ? (n / 2) : (n / 2) + 1;
        int nx, ny = 0;

        int start = 1;

        for (int i = 0; i < turn; i++) {
            nx = i;
            ny = i;
            int d = 0;

            answer[nx][ny] = start;
            start++;

            while (d < 4) {
                nx = nx + dx[d];
                ny = ny + dy[d];

                if (nx >= n || nx < 0 || ny >= n || ny < 0 || answer[nx][ny] > 0) {
                    nx -= dx[d];
                    ny -= dy[d];
                    d += 1;
                    continue;
                }

                answer[nx][ny] = start++;
            }
        }
        for (int[] i : answer) {
            System.out.println(Arrays.toString(i));
        }

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += answer[i][i];
        }
        System.out.println("sum : "+sum);
    }

    public static void main(String[] args) {
        Cospro1_5 sol = new Cospro1_5();
        sol.solution(7);
        sol.solution(4);
    }
}
