import java.util.Arrays;
import java.util.Stack;

public class Programmers67 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int temp = stack.pop();
                answer[temp] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            answer[temp] = -1;
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers67 test = new Programmers67();
        System.out.println(Arrays.toString(test.solution(new int[]{9, 1, 5, 3, 6, 2})));


    }
}
