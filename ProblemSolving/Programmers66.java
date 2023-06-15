import javax.swing.*;
import java.util.*;

public class Programmers66 {
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();

        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X') {
                    int temp = BFS(maps, i, j, n, m, visited);
                    if (temp != 0) {
                        answer.add(temp);
                    }
                }
            }
        }

        if (answer.isEmpty()) {
            answer.add(-1);
        } else {
            answer.sort(Comparator.naturalOrder());
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int BFS(String[] map, int i, int j, int n, int m, boolean[][] visited) {

        if (visited[i][j] == true) {
            return 0;
        }

        visited[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();

        int dx[] = new int[]{0, 0, 1, -1};
        int dy[] = new int[]{-1, 1, 0, 0};
        int sum = 0;

        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {

            int[] temp = queue.remove();
            int x = temp[0];
            int y = temp[1];
            sum += Integer.parseInt(String.valueOf(map[x].charAt(y)));

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx].charAt(ny) != 'X' && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        Programmers66 test = new Programmers66();
        System.out.println(Arrays.toString(test.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
        System.out.println(Arrays.toString(test.solution(new String[]{"XXX", "XXX", "XXX"})));
    }
}
