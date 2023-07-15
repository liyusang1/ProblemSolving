import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Programmers92_overrideSorting {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        List<String> list = new ArrayList<>();

        for (int i : numbers) {
            list.add(Integer.toString(i));
        }

        list.sort((s1, s2) -> {
            String left = s1 + s2;
            String right = s2 + s1;
            return right.compareTo(left);
        });

        if (list.get(0).equals("0")) {
            return "0";
        }

        for (String i : list) {
            answer.append(i);
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        Programmers92_overrideSorting test = new Programmers92_overrideSorting();
        System.out.println(test.solution(new int[]{3, 30, 34, 5, 9}));
    }
}

