import java.util.*;

public class Programmers_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int temp;
            if ((100 - progresses[i]) % (speeds[i]) == 0) {
                temp = (100 - progresses[i]) / (speeds[i]);
            } else {
                temp = (100 - progresses[i]) / (speeds[i]);
                temp++;
            }
            queue.add(temp);
        }

        int count = 0;
        int temp = queue.peek();

        while (!queue.isEmpty()) {
            if (queue.peek() <= temp) {
                count++;
                queue.remove();
            } else {
                list.add(count);
                temp = queue.peek();
                count = 0;
            }
        }
        list.add(count);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Programmers_기능개발 test = new Programmers_기능개발();
        System.out.println(Arrays.toString(test.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
    }
}

