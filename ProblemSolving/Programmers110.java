//멀리뛰기
//점화식 세우는 문제, answer을 보면서 점화식을 세워야함

public class Programmers110 {
    public long solution(int n) {
        int[] dp = new int[2001];

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;

        for (int i = 3; i < n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }

        return dp[n - 1];
    }


    public static void main(String[] args) {
        Programmers110 test = new Programmers110();
        System.out.println((test.solution(6)));
        System.out.println((test.solution(4)));
        System.out.println((test.solution(3)));
    }
}

