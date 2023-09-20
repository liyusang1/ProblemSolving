import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Programmers_택배상자 {
    public int solution(int[] order) {
        int answer = 0;
        List<Integer> base = IntStream.range(1, order.length + 1)
                .boxed()
                .collect(Collectors.toList());
        Stack<Integer> sub = new Stack<>();
        int index = 0;

        for (int i : base) {
            while (!sub.isEmpty() && sub.peek() == order[index]) { //보조벨트에 있는게 넣어야 한다면
                answer++;
                index++;
                sub.pop();
            }
            if (i == order[index]) { // 메인벨트에 있는게 넣어야 한다면
                answer++;
                index++;
            } else {
                sub.push(i);
            }
        }

        while (!sub.isEmpty() && sub.peek() == order[index]) { //보조에 남은것들을 넣을수 있는지
            answer++;
            index++;
            sub.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_택배상자 test = new Programmers_택배상자();
        System.out.println((test.solution(new int[]{4, 3, 1, 2, 5})));
    }
}

