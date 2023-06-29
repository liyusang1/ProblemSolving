import java.util.*;

public class Programmers81 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        int[][] arr = new int[rows][columns];
        int index = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = index++;
            }
        }

        index = 0;
        for (int[] query : queries) {
            int min = Integer.MAX_VALUE;

            int x = query[0] - 1;
            int y = query[1] - 1;
            int temp = arr[x][y];
            int temp2 = 0;
            int d = 0;

            while (true) {
                if (d >= 4) {
                    break;
                }
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < query[0] - 1 || ny < query[1] - 1 || nx >= query[2] || ny >= query[3]) {
                    d++;
                    continue;
                }
                temp2 = arr[nx][ny];
                arr[nx][ny] = temp;
                min = Math.min(temp, min);
                temp = temp2;
                x = nx;
                y = ny;
            }
            answer[index++] = min;
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers81 test = new Programmers81();
        System.out.println(Arrays.toString(test.solution(3, 3, new int[][]{
                {1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}
        })));

        System.out.println(Arrays.toString(test.solution(6, 6, new int[][]{
                {2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}
        })));
    }
}
