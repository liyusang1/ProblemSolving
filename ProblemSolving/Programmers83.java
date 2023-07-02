import java.util.Arrays;

public class Programmers83 {
    int zeroCount;
    int oneCount;

    public int[] solution(int[][] arr) {
        zeroCount = 0;
        oneCount = 0;

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    oneCount++;
                } else if (arr[i][j] == 0) {
                    zeroCount++;
                }
            }
        }

        recur(arr, n, 0, 0);
        int[] answer = new int[]{zeroCount, oneCount};

        return answer;
    }

    public void recur(int[][] arr, int size, int x, int y) {
        if (size <= 1) {
            return;
        }

        System.out.println(zeroCount);
        System.out.println(oneCount);
        System.out.println("--");

        int first = arr[x][y];
        boolean check = true;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != first) {
                    check = false;
                    break;
                }
            }
        }

        if (check) {
            if (first == 0) {
                zeroCount -= (size * size);
                zeroCount++;
            } else {
                oneCount -= (size * size);
                oneCount++;
            }
            return;
        }
        recur(arr, size / 2, x, y);
        recur(arr, size / 2, x, y + size / 2);
        recur(arr, size / 2, x + size / 2, y);
        recur(arr, size / 2, x + size / 2, y + size / 2);
    }

    public static void main(String[] args) {

        Programmers83 test = new Programmers83();
        System.out.println(Arrays.toString(test.solution(
                new int[][]{
                        {1, 1, 0, 0},
                        {1, 0, 0, 0},
                        {1, 0, 0, 1},
                        {1, 1, 1, 1}
                }
        )));

        System.out.println(Arrays.toString(test.solution(
                new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 1, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1}
                }
        )));
    }
}
