import java.util.ArrayList;
import java.util.Arrays;
//줄서는 방법

public class Programmers108 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }

        int i = 0;
        long remain = k - 1;
        // k가 1부터 시작하므로

        while (i < n) {
            factorial = factorial / (n - i);
            long value = remain / factorial;
            answer[i++] = list.get((int) value);
            list.remove((int) value);
            remain = remain % factorial;
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers108 test = new Programmers108();
        System.out.println(Arrays.toString(test.solution(3, 5)));
    }
}

