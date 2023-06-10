import java.util.*;

public class Programmers56 {
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

        Programmers56 test = new Programmers56();
        System.out.println((test.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
                new int[]{1, 5, 3, 5, 1, 2, 1, 4})));

    }
}
