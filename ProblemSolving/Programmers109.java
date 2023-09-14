import java.util.ArrayList;
import java.util.Arrays;
//숫자의 표현

public class Programmers109 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers109 test = new Programmers109();
        System.out.println((test.solution(15)));
    }
}

