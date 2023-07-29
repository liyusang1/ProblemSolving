import java.util.*;

//프로그래머스 점프와 순간이동
public class Programmers101 {
    public int solution(int n) {
        /*
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length - 1; i++) {

            if (dp[i + 1] == 0) {
                dp[i + 1] = dp[i] + 1;
            } else {
                dp[i + 1] = Math.min(dp[i] + 1, dp[i + 1]);
            }

            if (i * 2 <= n && i != 0) {
                if (dp[i * 2] == 0) {
                    dp[i * 2] = dp[i];
                } else {
                    dp[i * 2] = Math.min(dp[i], dp[i * 2]);
                }
            }
        }
        return dp[n];
         */

        int answer = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                n -= 1;
                answer++;
            } else {
                n /= 2;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers101 test = new Programmers101();
        System.out.println(test.solution(5));
        System.out.println(test.solution(6));
        System.out.println(test.solution(5000));
    }
}

