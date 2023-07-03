import java.util.Arrays;

public class Programmers84 {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];

        int x = -1;
        int y = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (i % 3 == 0) { // 대각선 아래
                    x++;
                } else if (i % 3 == 1) { // 가로
                    y++;
                } else if (i % 3 == 2) { // 대각선 위
                    x--;
                    y--;
                }

                arr[x][y] = num++;
            }
        }

        int[] answer = new int[n*(n+1) / 2]; // 삼각형의 크기 ( 1 ~ n 까지 합)

        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0) break;
                answer[index++] = arr[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers84 test = new Programmers84();
        System.out.println(Arrays.toString(test.solution(4)));
        System.out.println(Arrays.toString(test.solution(5)));
        System.out.println(Arrays.toString(test.solution(7)));

    }
}
