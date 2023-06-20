import java.util.*;

public class Programmers72 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i : map.values()) {
            list.add(i);
        }
        list.sort(Comparator.reverseOrder());

        long sum = 0;
        int i = 0;
        while (sum < k) {
            sum += list.get(i);
            answer++;
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers72 test = new Programmers72();
        System.out.println(test.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3})); //3
        System.out.println(test.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3})); //2
        System.out.println(test.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3})); //1

        System.out.println(test.solution(3, new int[]{3, 3, 3, 1, 2, 2, 2, 1, 1}));


    }
}
