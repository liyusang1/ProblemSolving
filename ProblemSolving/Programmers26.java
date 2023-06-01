import java.util.Arrays;

public class Programmers26 {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int curCount = 0;
        int zeroCount = 0;

        for (int j = 0; j < win_nums.length; j++) {
            if (lottos[j] == 0) {
                zeroCount += 1;
                continue;
            }
        }

        for (int i = 0; i < win_nums.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[j] == win_nums[i]) {
                    curCount += 1;
                    break;
                }
            }
        }

        answer[1] = getCount(curCount);
        answer[0] = getCount(curCount + zeroCount);

        return answer;
    }

    public int getCount(int n) {
        if (n >= 6) {
            return 1;
        } else if (n == 5) {
            return 2;
        } else if (n == 4) {
            return 3;
        } else if (n == 3) {
            return 4;
        } else if (n == 2) {
            return 5;
        }
        return 6;
    }


    public static void main(String[] args) {

        Programmers26 test = new Programmers26();

        System.out.println(Arrays.toString(test.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
    }
}
