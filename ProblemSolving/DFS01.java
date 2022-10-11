public class DFS01 {
    static boolean Solution(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board[0].length; i++) {
                if (dfs(board, j, i, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(char[][] board, int x, int y, String word, int i, boolean[][] visited) {
        int[][] dir = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        if (i == word.length()) {
            return true;
        }

        if (y >= board[0].length || x >= board.length || x < 0 || y < 0) {
            return false;
        }
        if (visited[x][y] == true) {
            return false;
        }
        if (board[x][y] != word.charAt(i)) {
            return false;
        }
        visited[x][y] = true;
        for (int[] k : dir) {

            if (dfs(board, x + k[0], y + k[1], word, i + 1, visited)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        System.out.println(Solution(board, "ABCCED"));
        System.out.println(Solution(board, "ABCCEE"));
        System.out.println(Solution(board, "ABCCEDA"));
        System.out.println(Solution(board, "ABCCEDAS"));
        System.out.println(Solution(board, "ABCCEDASFB"));
    }
}
