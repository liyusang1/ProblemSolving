import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

//프로그래머스 최솟값 만들기
public class Programmers105 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - i - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers105 test = new Programmers105();
        System.out.println(test.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
    }
}

