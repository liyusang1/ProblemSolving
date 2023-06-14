import java.util.LinkedList;
import java.util.Queue;

public class Programmers64 {

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[][] visited = new int[n][m];
        int[][] visited2 = new int[n][m];
        int tempLever = 0;
        int exit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    BFS(maps, i, j, visited, n, m);
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'L') {
                    tempLever = visited[i][j];
                    BFS(maps, i, j, visited2, n, m);
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'E') {
                    exit = visited2[i][j];
                }
            }
        }

        if (exit != 0 && tempLever != 0) {
            return exit + tempLever;
        } else {
            return -1;
        }
    }

    public int BFS(String[] maps, int i, int j, int[][] visited, int n, int m) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] number = queue.remove();
            int x = number[0];
            int y = number[1];

            for (int t = 0; t < 4; t++) {
                int nx = x + dx[t];
                int ny = y + dy[t];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx].charAt(ny) != 'X' && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Programmers64 test = new Programmers64();
        System.out.println(test.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
        System.out.println(test.solution(new String[]{"SOOO", "XXXO", "OOOO", "OXXO", "LXXE"}));
        System.out.println(test.solution(new String[]{"SOOO", "XXXO", "OOOO", "OXXX", "LXXE"}));

        System.out.println(test.solution(new String[]{"SOEOL", "XXXXO", "OOOOO", "OXXXX", "OOOOO"}));
        System.out.println(test.solution(new String[]{"SLEOX", "XXXXO", "OOOOO", "OXXXX", "OOOOO"}));

        System.out.println(test.solution(new String[]{"SELOX", "XXXXO", "OOOOO", "OXXXX", "OOOOO"}));
        System.out.println(test.solution(new String[]{"SLXOX", "EXXXO", "OOOOO", "OXXXX", "OOOOO"}));
        System.out.println(test.solution(new String[]{"SXXOX", "EXXXL", "OOXOO", "OXXXX", "OOOOO"}));


        System.out.println(test.solution(new String[]{"SXXOX", "EXXXL", "OOXOO", "OOOOO"}));

    }
}
