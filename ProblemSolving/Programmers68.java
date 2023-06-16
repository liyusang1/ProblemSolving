import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class Programmers68 {
    public int solution(int x, int y, int n) {

        int[] dp = new int[y + 1];

        for (int i = x; i < y + 1; i++) {
            if (i != x && dp[i] == 0) {
                dp[i] = -1;
                continue;
            }

            if (i * 2 <= y) {
                if (dp[i * 2] == 0) {
                    dp[i * 2] = dp[i] + 1;
                } else {
                    dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);
                }
            }

            if (i * 3 <= y) {
                if (dp[i * 3] == 0) {
                    dp[i * 3] = dp[i] + 1;
                } else {
                    dp[i * 3] = Math.min(dp[i] + 1, dp[i * 3]);
                }
            }

            if (i + n <= y) {
                if (dp[i + n] == 0) {
                    dp[i + n] = dp[i] + 1;
                } else {
                    dp[i + n] = Math.min(dp[i] + 1, dp[i + n]);
                }
            }
        }

        return dp[y];
    }


    public static void main(String[] args) {

        Programmers68 test = new Programmers68();
        System.out.println(test.solution(10, 40, 5));
        System.out.println(test.solution(10, 40, 30));
    }
}
