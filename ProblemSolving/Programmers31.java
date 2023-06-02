import java.util.*;

public class Programmers31 {

    public int solution(int n, int[] lost, int[] reserve) {

        int answer = n - lost.length;
        Set<Integer> list2 = new HashSet<>();

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i : reserve) {
            list2.add(i);
        }

        for (int i = 0; i < lost.length; i++) {
            if (list2.contains(lost[i])) {
                answer += 1;
                list2.remove(lost[i]);
                lost[i] = -1;
            }
        }

        for (int i : lost) {
            if (i == -1) {
                continue;
            }
            if (list2.contains(i - 1)) {
                answer += 1;
                list2.remove(i - 1);
            } else if (list2.contains(i + 1)) {
                answer += 1;
                list2.remove(i + 1);
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        Programmers31 test = new Programmers31();
        System.out.println(test.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(test.solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(test.solution(3, new int[]{3}, new int[]{1}));
        System.out.println(test.solution(5, new int[]{5}, new int[]{1}));
        System.out.println(test.solution(5, new int[]{4, 5}, new int[]{3, 4}));
    }
}
