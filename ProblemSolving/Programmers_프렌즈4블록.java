public class Programmers_프렌즈4블록 {

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int[][] map; // 사라진 블록 개수 저장

        char[][] boards = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            boards[i] = board[i].toCharArray();
        }

        while (true) {
            int count = 0;
            map = new int[m][n];

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = boards[i][j];
                    if (c == boards[i + 1][j] && c == boards[i + 1][j + 1] && c == boards[i][j + 1]) { // 정사각형인지 판별
                        map[i + 1][j]++;
                        map[i + 1][j + 1]++;
                        map[i][j + 1]++;
                        map[i][j]++;
                        count++;
                    }
                }
            }

            if ((m == 2) && (n == 2)) {
                return count == 1 ? 4 : 0; //정사각형이 있다면 기록
            }

            if (count == 0) { // 정사각형이 없다면 -> 없으므로 while문 종료
                break;
            }

            // 블록 삭제
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > 0) boards[i][j] = (char) i;
                }
            }

            // 블록 내리기 (밑에서부터 당기기)
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] == 0) {
                        boards[i + cnt][j] = boards[i][j];
                    } else {
                        cnt++;
                    }
                }
                answer += cnt;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_프렌즈4블록 test = new Programmers_프렌즈4블록();
        System.out.println(test.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"})); //14
    }
}

