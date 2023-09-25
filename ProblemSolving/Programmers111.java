//땅따먹기
import java.util.Arrays;

public class Programmers111 {
    int solution(int[][] land) {

        for (int i = 1; i < land.length; i++) {
            land[i][0] = Math.max(Math.max(land[i][0] + land[i - 1][1], land[i][0] + land[i - 1][2]), land[i][0] + land[i - 1][3]);
            land[i][1] = Math.max(Math.max(land[i][1] + land[i - 1][0], land[i][1] + land[i - 1][2]), land[i][1] + land[i - 1][3]);
            land[i][2] = Math.max(Math.max(land[i][2] + land[i - 1][0], land[i][2] + land[i - 1][1]), land[i][2] + land[i - 1][3]);
            land[i][3] = Math.max(Math.max(land[i][3] + land[i - 1][0], land[i][3] + land[i - 1][1]), land[i][3] + land[i - 1][2]);
        }

        Arrays.sort(land[land.length - 1]);
        return land[land.length - 1][3];
    }


    public static void main(String[] args) {
        Programmers111 test = new Programmers111();
        System.out.println((test.solution(new int[][]{
                {1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}
        })));
    }
}

