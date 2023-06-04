import java.util.Arrays;

public class Programmers37 {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (getGcdCount(nums[i] + nums[j] + nums[k]) == 2) {
                        answer += 1;
                    }
                }
            }
        }

        return answer;
    }

    public int getGcdCount(int n) {
        int count = 0;
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {

            if (n % i == 0) {
                count += 1;
                if (n / i != i) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Programmers37 test = new Programmers37();
        System.out.println(test.solution(new int[]{1, 2, 3, 4}));
        System.out.println(test.solution(new int[]{1, 2, 7, 6, 4}));
    }
}
