import java.util.Arrays;

public class Programmers38 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long temp = x;

        for (int i = 0; i < n; i++) {
            answer[i] = temp;
            temp += x;
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers38 test = new Programmers38();
        System.out.println(Arrays.toString(test.solution(2, 5)));
        System.out.println(Arrays.toString(test.solution(4, 3)));
        System.out.println(Arrays.toString(test.solution(-4, 2)));
    }
}
