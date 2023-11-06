//가장 큰 정사각형 찾기
//dp문제 점화식 세우기
//테케 1번 오류 있음

public class Programmers113_DP {
    public int solution(int[][] board) {
        int answer = Integer.MIN_VALUE;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                board[i][j] = Math.min(board[i - 1][j], Math.min(board[i - 1][j - 1], board[i][j - 1])) + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }

        return answer * answer;
    }

    public static void main(String[] args) {
        Programmers113_DP test = new Programmers113_DP();
        System.out.println(test.solution(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0}
        }));
        System.out.println(test.solution(new int[][]{
                {1, 1},
                {1, 1}
        }));
    }
}

