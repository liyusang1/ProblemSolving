import java.util.*;

public class Programmers_리코쳇로봇 {
    private class Moving {
        int x, y, depth;

        public Moving(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public int BFS(int n, int m, String[] board, Moving robot, Moving goal) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Moving> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.add(robot);
        visited[robot.x][robot.y] = true;

        while (!queue.isEmpty()) {

            Moving temp = queue.remove();

            if (temp.x == goal.x && temp.y == goal.y) {
                return temp.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nx = temp.x;
                int ny = temp.y;

                while (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx].charAt(ny) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }

                nx -= dx[i];
                ny -= dy[i];

                if (visited[nx][ny] || (temp.x == nx && temp.y == ny)) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new Moving(nx, ny, temp.depth + 1));
            }
        }
        return -1;
    }

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();

        Moving robot = null;
        Moving goal = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i].charAt(j) == 'R') {
                    robot = new Moving(i, j, 0);
                } else if (board[i].charAt(j) == 'G') {
                    goal = new Moving(i, j, 0);
                }
            }
        }
        return BFS(n, m, board, robot, goal);
    }

    public static void main(String[] args) {
        Programmers_리코쳇로봇 test = new Programmers_리코쳇로봇();
        System.out.println(test.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    }
}

