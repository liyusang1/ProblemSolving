public class Programmers63 {
    public int solution(String[] board) {
        int answer = 1;
        int OCount = 0;
        int XCount = 0;
        int O = 0;
        int X = 0;
        int dot = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') {
                    O++;
                    OCount += check(board, i, j);
                } else if (board[i].charAt(j) == 'X') {
                    X++;
                    XCount += check(board, i, j);
                } else if (board[i].charAt(j) == '.') {
                    dot++;
                }
            }
        }
        //둘다 줄이 생긴경우
        if (OCount >= 1 && XCount >= 1) {
            answer = 0;
        }
        // O가 2개 더 많은 경우
        if (O > X + 1) {
            answer = 0;
        }
        //x가 더 많은 경우
        if (O < X) {
            answer = 0;
        }
        //칸이 다 찻는데 x가 o와 같거나 많은 경우
        if (dot == 0 && X >= O) {
            answer = 0;
        }
        //O가 이겻는데 x와 같거나 x가 많은 경우
        if (OCount >= 1 && X >= O) {
            answer = 0;
        }
        // x가 이겻는데 o와 x의 개수가 다른경우
        if (XCount >= 1 && X != O) {
            answer = 0;
        }

        return answer;
    }

    public int check(String[] board, int i, int j) {

        int check = 0;
        //세로
        if (i == 0) {
            if (board[i].charAt(j) == board[i + 1].charAt(j) && board[i + 1].charAt(j) == board[i + 2].charAt(j)) {
                check++;
            }
        }
        //가로
        if (j == 0) {
            if (board[i].charAt(j) == board[i].charAt(j + 1) && board[i].charAt(j + 1) == board[i].charAt(j + 2)) {
                check++;
            }
        }
        //대각
        if (i == 0 && j == 0) {
            if (board[i].charAt(j) == board[i + 1].charAt(j + 1) && board[i + 1].charAt(j + 1) == board[i + 2].charAt(j + 2)) {
                check++;
            }
        }
        if (i == 2 && j == 0) {
            if (board[i].charAt(j) == board[i - 1].charAt(j + 1) && board[i - 1].charAt(j + 1) == board[i - 2].charAt(j + 2)) {
                check++;
            }
        }
        return check;
    }

    public static void main(String[] args) {

        Programmers63 test = new Programmers63();
        System.out.println(test.solution(new String[]{"O.X", ".O.", "..X"}));
        System.out.println(test.solution(new String[]{"OOO", "...", "XXX"}));
        System.out.println(test.solution(new String[]{"...", ".X.", "..."}));
        System.out.println(test.solution(new String[]{"...", "...", "..."}));
        System.out.println(test.solution(new String[]{"OOO", "XOX", "XXO"}));
        System.out.println(test.solution(new String[]{"OOO", "OXX", "OXX"}));
    }
}
