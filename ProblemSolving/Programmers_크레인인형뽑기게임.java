import java.util.*;

public class Programmers_크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Deque<Integer>[] stack = new Deque[board.length];
        for (int i = 0; i < stack.length; i++) {
            stack[i] = new ArrayDeque<>();
        }

        for (int[] nums : board) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    continue;
                } else {
                    stack[i].addFirst(nums[i]);
                }
            }
        }

        Stack<Integer> conclusion = new Stack<>();

        for (int i : moves) {
            if (stack[i - 1].size() == 0) {
                continue;
            }
            if (conclusion.size() != 0) {
                if (conclusion.peek() == stack[i-1].getLast()) {
                    answer += 2;
                    conclusion.pop();
                    stack[i - 1].removeLast();
                    continue;
                }
            }
            conclusion.push(stack[i - 1].removeLast());
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_크레인인형뽑기게임 test = new Programmers_크레인인형뽑기게임();
    }
}

