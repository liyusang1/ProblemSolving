import java.util.*;
//프로그래머스 기능개발
public class Programmers95 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int temp = 100 - progresses[i];
            if (temp % speeds[i] == 0) {
                queue.add(temp / speeds[i]);
            } else {
                queue.add(temp / speeds[i] + 1);
            }
        }

        while (!queue.isEmpty()) {
            int count = 1;
            int temp = queue.remove();

            while (!queue.isEmpty() && queue.peek() <= temp) {
                queue.remove();
                count++;
            }
            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        Programmers95 test = new Programmers95();
        System.out.println(Arrays.toString(test.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
    }
}

