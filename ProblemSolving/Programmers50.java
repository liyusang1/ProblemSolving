import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Programmers50 {
    public List solution(int[] arr, int divisor) {

        List<Integer> answer = new ArrayList<>();

        for (int i : arr) {
            if (i % divisor == 0) {
                answer.add(i);
            }
        }

        answer.sort(Comparator.naturalOrder());
        if (answer.size() == 0) {
            answer.add(-1);
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers50 test = new Programmers50();
        System.out.println((test.solution(new int[]{5, 9, 7, 10}, 5)));
    }
}
