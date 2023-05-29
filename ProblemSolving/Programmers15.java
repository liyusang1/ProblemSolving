import java.util.Stack;

public class Programmers15 {

    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i : ingredient) {
            stack.push(i);
            if (stack.peek() == 1 && stack.size() >= 4 && stack.get(stack.size() - 2) == 3 && stack.get(stack.size() - 3) == 2
                    && stack.get(stack.size() - 4) == 1) {

                for (int k = 0; k < 4; k++) {
                    stack.pop();

                }

                answer += 1;
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        Programmers15 test = new Programmers15();

        System.out.println(test.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(test.solution(new int[]{1, 2, 1, 2, 3, 1, 3, 1, 1, 2, 3, 1}));
        System.out.println(test.solution(new int[]{2, 3, 1}));
    }
}
