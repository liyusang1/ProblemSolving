import java.util.Arrays;

public class Programmers49 {
    public long solution(int a, int b) {
        long answer = 0;

        int max = 0;
        int min = 0;
        if (a > b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }

        answer += getSum(max) - getSum(min - 1);

        return answer;
    }

    public long getSum(long n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {

        Programmers49 test = new Programmers49();
        System.out.println(test.solution(3, 5));
        System.out.println(test.solution(3, 3));
        System.out.println(test.solution(5, 3));
        System.out.println(test.solution(0, 100));
        System.out.println(test.solution( 100,0));
    }
}
