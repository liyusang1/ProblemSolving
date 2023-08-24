import java.util.*;

public class Programmers_무인도여행 {
    public int BFS(String[] maps, boolean[][] visited, int i, int j, int n, int m) {
        int sum = 0;

        if (visited[i][j]) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] temp = queue.remove();
            sum += Integer.parseInt(String.valueOf(maps[temp[0]].charAt(temp[1])));

            int[] dx = new int[]{0, 0, 1, -1};
            int[] dy = new int[]{1, -1, 0, 0};

            for (int k = 0; k < 4; k++) {
                int nx = temp[0] + dx[k];
                int ny = temp[1] + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || maps[nx].charAt(ny) == 'X') {
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        return sum;
    }

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList();
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X') {
                    int temp = BFS(maps, visited, i, j, n, m);
                    if (temp != -1) {
                        answer.add(temp);
                    }
                }
            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        }

        answer.sort(Comparator.naturalOrder());
        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Programmers_무인도여행 test = new Programmers_무인도여행();
        System.out.println(Arrays.toString(test.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
    }
}

