import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Programmers_택배상자꺼내기 {
    public static void main(String[] args) {
        Programmers_택배상자꺼내기 sol = new Programmers_택배상자꺼내기();
        sol.solution(22, 6, 8); //3
        sol.solution(13, 3, 6); //4
        sol.solution(4, 3, 4); //4
        sol.solution(2, 1, 1); //4
        sol.solution(100, 9, 47); //6

    }

    public int solution(int n, int w, int num) {
        int answer = 0;

        List<Stack<Integer>> stackList = new ArrayList<Stack<Integer>>();
        for (int i = 0; i < w; i++) {
            Stack<Integer> tempStack = new Stack<>();
            stackList.add(tempStack);
        }

        boolean isIncreasing = true;
        int curStack = 0;
        for (int i = 1; i <= n; i++) {
            stackList.get(curStack).push(i);

            //주의 테스트케이스 w가 1인경우는 예외 처리를 해주어야 함.
            if (w != 1) {
                if (isIncreasing) {
                    curStack++;
                } else {
                    curStack--;
                }
                if (curStack == w - 1) {
                    stackList.get(curStack).push(i + 1);
                    i++;
                    isIncreasing = false;
                } else if (curStack == 0) {
                    stackList.get(curStack).push((i + 1));
                    i++;
                    isIncreasing = true;
                }
            }
        }

        for (int i = 0; i < stackList.size(); i++) {
            answer = 0;
            while (!stackList.get(i).isEmpty()) {
                answer++;
                if (stackList.get(i).pop() == num) {
                    return answer;
                }
            }
        }

        return answer;
    }
}
