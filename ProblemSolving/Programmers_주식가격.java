import java.util.*;

public class Programmers_주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) { //감소하는 값이 나왓을 경우
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i); //스택에 answer의 인덱스를 push
        }

        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_주식가격 test = new Programmers_주식가격();
        System.out.println(Arrays.toString(test.solution(new int[]{1, 2, 3, 2, 3})));
        System.out.println(Arrays.toString((test.solution(new int[]{4, 3, 2, 2, 1}))));
    }
}

