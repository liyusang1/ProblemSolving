import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers10 {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        List check = new ArrayList();

        for (int i = 0; i < s.length(); i++) {

            if (!check.contains(s.charAt(i))) {
                check.add(s.charAt(i));
                answer[i] = -1;
            } else {
                int temp = 0;
                for (int j = i - 1; j >= 0; j--) {
                    temp += 1;
                    if (s.charAt(j) == s.charAt(i)) {
                        break;
                    }
                }
                answer[i] = temp;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers10 test = new Programmers10();
        System.out.println(Arrays.toString(test.solution("banana")));
        System.out.println(Arrays.toString(test.solution("aaaaaa")));
        System.out.println(Arrays.toString(test.solution("foobar")));
    }
}
