import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Programmers75 {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int temp = 0;
        int index = 1;

        for (int i = 0; i < elements.length; i++) {
            for (int k = 0; k < elements.length; k++) {
                for (int t = k; t < k + index; t++) {
                    int temp2 = t;
                    if (temp2 > elements.length - 1) {
                        temp2 = temp2 % (elements.length);
                    }
                    temp += elements[temp2];
                }
                set.add(temp);
                temp = 0;

            }
            index++;
        }

        return set.size();
    }

    public static void main(String[] args) {

        Programmers75 test = new Programmers75();
        System.out.println(test.solution(new int[]{7, 9, 1, 1, 4}));
        System.out.println(test.solution(new int[]{1, 2, 2, 4}));
    }
}
