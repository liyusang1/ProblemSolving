import java.util.Arrays;
import java.util.Comparator;

public class Programmers_단속카메라 {
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, Comparator.comparing(i -> i[1]));

        int min = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            if (min >= routes[i][0] && min <= routes[i][1]) {
            } else {
                answer++;
                min = routes[i][1];
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Programmers_단속카메라 test = new Programmers_단속카메라();
        System.out.println(test.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
        System.out.println(test.solution(new int[][]{{-100, 100}, {50, 170}, {150, 200}, {-50, -10}, {10, 20}, {30, 40}}));


    }
}

