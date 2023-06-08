import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Programmers51 {
    public int[] solution(int[] arr) {

        List<Integer> number = new ArrayList<>();
        number.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (number.get(number.size() - 1) != arr[i]) {
                number.add(arr[i]);
            }
        }

        int[] answer = new int[number.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = number.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers51 test = new Programmers51();
        System.out.println(Arrays.toString(test.solution(new int[]{1, 2, 2, 2, 3, 3, 3, 4, 5})));
    }
}
