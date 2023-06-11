import java.util.Arrays;
import java.util.Comparator;

public class Programmers58 {

    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));
        int nowNumber = targets[0][1];

        for (int i = 1; i < targets.length; i++) {
            if (targets[i][0] >= nowNumber) {
                answer += 1;
                nowNumber = targets[i][1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers58 test = new Programmers58();
        System.out.println(test.solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}}));
    }
}
