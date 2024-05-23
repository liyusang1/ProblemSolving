import java.util.Arrays;

public class Programmers_최고의집합 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        if (n > s) {
            return new int[]{-1};
        }

        int num = s / n;
        Arrays.fill(answer, num);

        int index = n - 1;
        for (int i = 0; i < s % n; i++) {
            answer[index]++;
            index--;
        }

        return answer;
    }


    public static void main(String[] args) {
        Programmers_최고의집합 test = new Programmers_최고의집합();
        System.out.println(test.solution(2, 9));
    }
}

