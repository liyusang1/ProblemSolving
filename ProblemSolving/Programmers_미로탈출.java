import java.util.LinkedList;
import java.util.Queue;

public class Programmers_미로탈출 {
    public void BFS(int[][] maze, String[] maps, boolean[][] visited, int x, int y, int n, int m) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] temp = queue.remove();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || maps[nx].charAt(ny) == 'X' || visited[nx][ny] == true) {
                    continue;
                }

                visited[nx][ny] = true;
                maze[nx][ny] = maze[temp[0]][temp[1]] + 1;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[][] maze = new int[n][m]; //2차원 배열을 만들어서 경로최솟값을 갱신하며 저장함.
        boolean[][] visited = new boolean[n][m];
        int startX = 0, startY = 0, leverX = 0, leverY = 0, exitX = 0, exitY = 0;

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'L') {
                    leverX = i;
                    leverY = j;
                } else if (maps[i].charAt(j) == 'E') {
                    exitX = i;
                    exitY = j;
                } else if (maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        BFS(maze, maps, visited, startX, startY, n, m);
        if (maze[leverX][leverY] == 0) { //레버까지 도달 할 수 없을 때
            return -1;
        }

        int mazeRestartPoint = maze[leverX][leverY];
        maze = new int[n][m];
        maze[leverX][leverY] = mazeRestartPoint;
        visited = new boolean[n][m];
        BFS(maze, maps, visited, leverX, leverY, n, m);

        return (maze[exitX][exitY] == 0) ? -1 : maze[exitX][exitY]; //출구 까지 갈 수 없으면 -1
    }

    public static void main(String[] args) {
        Programmers_미로탈출 test = new Programmers_미로탈출();
        System.out.println(test.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
        System.out.println(test.solution(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}));
    }
}
