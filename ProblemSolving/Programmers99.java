import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//프로그래머스 예상 대진표
public class Programmers99 {
    public int solution(int n, int a, int b) {
        int answer = 1;

        List<Integer> arr = IntStream.range(1, n + 1)
                .boxed()
                .collect(Collectors.toList());

        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        while (true) {
            boolean check = false;

            for (int i = 0; i < arr.size(); i++) {
                if (i % 2 == 0) {
                    queue1.add(arr.get(i));
                } else {
                    queue2.add(arr.get(i));
                }
            }

            arr = new ArrayList<>();
            int size = queue1.size();

            for (int k = 0; k < size; k++) {
                if (queue1.peek() == a && queue2.peek() == b) {
                    check = true;
                    break;
                } else if (queue1.peek() == b && queue2.peek() == a) {
                    check = true;
                    break;
                } else if (queue1.peek() == a || queue1.peek() == b) {
                    arr.add(queue1.peek());
                } else if (queue2.peek() == a || queue2.peek() == b) {
                    arr.add(queue2.peek());
                } else {
                    arr.add(queue1.peek());
                }
                queue1.remove();
                queue2.remove();
            }

            arr.sort(Comparator.naturalOrder());

            if (check) {
                break;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers99 test = new Programmers99();
        System.out.println(test.solution(16, 1, 16));
        System.out.println(test.solution(8, 4, 7));
    }
}

