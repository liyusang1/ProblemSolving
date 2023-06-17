import java.util.Arrays;

public class Programmers70 {
    public int solution(int storey) {
        int answer = 0;

        String[] temp = String.valueOf(storey).split("");
        int[] numbers = new int[temp.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(temp[i]);
        }

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] > 5) {
                answer += 10 - numbers[i];
                if (i == 0) {
                    answer++;
                } else {
                    numbers[i - 1] += 1;
                }
            } else if (i != 0 && numbers[i] == 5 && numbers[i - 1] >= 5) {
                answer += 5;
                numbers[i - 1] += 1;
            } else {
                answer += numbers[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers70 test = new Programmers70();
        System.out.println(test.solution(16));
        System.out.println(test.solution(2554));
        System.out.println(test.solution(5));
    }
}
