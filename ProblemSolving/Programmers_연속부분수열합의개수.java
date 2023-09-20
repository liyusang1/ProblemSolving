import java.util.*;

public class Programmers_연속부분수열합의개수 {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        int temp = 0;
        int index = 1;

        for (int i = 0; i < elements.length; i++) {

            for (int k = 0; k < elements.length; k++) {
                for (int t = k; t < k + index; t++) {

                    int temp2 = t;

                    if (temp2 > elements.length - 1) {
                        temp2 = temp2 % (elements.length); //길이를 넘었다면 다시 처음으로
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
        Programmers_연속부분수열합의개수 test = new Programmers_연속부분수열합의개수();
        System.out.println((test.solution(new int[]{7, 9, 1, 1, 4})));
    }
}

