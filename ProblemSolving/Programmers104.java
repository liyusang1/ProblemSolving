import java.util.Arrays;

//프로그래머스 행렬의 곱셈
//구현문제
public class Programmers104 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int x = arr1.length;
        int y = arr2[0].length;
        int[][] answer = new int[x][y];
        int a = 0;
        int b = 0;
        int c;
        int temp;

        for (int i = 0; i < x; i++) {
            c = 0;
            for (int j = 0; j < y; j++) {

                temp = 0;
                for (int k = 0; k < arr2.length; k++) {
                    temp += arr1[a][b] * arr2[k][c];
                    b++;
                }
                b = 0;
                answer[i][j] = temp;
                c++;
            }
            a++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers104 test = new Programmers104();


        System.out.println(test.solution(new int[][]{
                        {1, 4}, {3, 2}, {4, 1}
                },
                new int[][]{
                        {3, 3}, {3, 3}
                }
        ));


        System.out.println(test.solution(new int[][]{
                        {2, 3, 2}, {4, 2, 4}, {3, 1, 4}
                },
                new int[][]{
                        {5, 4, 3}, {2, 4, 1}, {3, 1, 1}
                }
        ));
    }
}

