import java.util.*;

public class Programmers28 {

    public List<Integer> solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> list = new ArrayList(set);
        list.sort(Comparator.naturalOrder());
        return list;
    }

    public static void main(String[] args) {

        Programmers28 test = new Programmers28();
        System.out.println(test.solution(new int[]{2, 1, 3, 4, 1}));
    }
}
