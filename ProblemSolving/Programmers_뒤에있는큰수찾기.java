import java.util.*;

public class Programmers_뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) { //스택에 현재 있는 인덱스의 숫자보다 현재i가 크다면 뒤에있는큰수임-> pop하고 answer에 추가
                int temp = stack.pop();
                answer[temp] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) { //stack에 남아있는 수들은 뒤에 그 수보다 큰 수가 없다는 뜻 -> -1로 전부 바꿔줌
            int temp = stack.pop();
            answer[temp] = -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_뒤에있는큰수찾기 test = new Programmers_뒤에있는큰수찾기();
        System.out.println(test.solution(new int[]{2, 3, 3, 5}));
    }
}

