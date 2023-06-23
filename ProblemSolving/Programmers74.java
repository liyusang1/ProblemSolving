import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Programmers74 {
    public int solution(int[] order) {
        int answer = 0;
        List<Integer> base = IntStream.range(1, order.length + 1)
                .boxed()
                .collect(Collectors.toList());
        Stack<Integer> sub = new Stack<>();
        int index = 0;

        for (int i : base) {
            while (!sub.isEmpty() && sub.peek() == order[index]) {
                answer++;
                index++;
                sub.pop();
            }
            if (i == order[index]) {
                answer++;
                index++;
                continue;
            } else {
                sub.push(i);
            }
        }

        while (!sub.isEmpty() && sub.peek() == order[index]) {
            answer++;
            index++;
            sub.pop();
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers74 test = new Programmers74();

        System.out.println(test.solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(test.solution(new int[]{5, 4, 3, 2, 1}));
        System.out.println(test.solution(new int[]{3, 2, 4, 5, 1, 6}));

    }
}
