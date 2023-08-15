import java.util.*;

public class Programmers_혼자서하는틱택토 {
    public int solution(String[] board) {
        int Xcount = 0, dot = 0, Ocount = 0, OlineCount = 0, XlineCount = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'X') {
                    Xcount++;
                    XlineCount += checkLine(board, i, j);
                } else if (board[i].charAt(j) == 'O') {
                    Ocount++;
                    OlineCount += checkLine(board, i, j);
                } else {
                    dot++;
                }
            }
        }

        if (XlineCount >= 1 && Xcount != Ocount) { //Xline이 하나있는데 X와 O의 개수가 다른 경우
            return 0;
        } else if (dot == 0 && Xcount >= Ocount) { //칸이 전부 찻는데 X개수가 더 많거나 같은경우
            return 0;
        } else if (OlineCount >= 1 && Xcount >= Ocount) { //Oline이 있는데 X개수가 더 많거나 같은경우
            return 0;
        } else if (OlineCount >= 1 && XlineCount >= 1) { //라인이 2개 이상인 경우
            return 0;
        } else if (Xcount > Ocount) { //X가 더 많은경우
            return 0;
        } else if (Ocount > Xcount + 1) { //O가 한 개 더 많은 경우
            return 0;
        }

        return 1;
    }

    public int checkLine(String[] board, int i, int j) {

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
            if (board[i].charAt(j) == board[i + 1].charAt(j + 1) && board[i+1].charAt(j + 1) == board[i+2].charAt(j + 2)) {
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
        Programmers_혼자서하는틱택토 test = new Programmers_혼자서하는틱택토();
        System.out.println((test.solution(new String[]{
                "O.X",
                ".O.",
                "..X"})));
        System.out.println((test.solution(new String[]{
                "...",
                "...",
                "..."})));

    }
}

