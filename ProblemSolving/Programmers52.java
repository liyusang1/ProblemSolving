import java.util.*;

public class Programmers52 {
    public int solution(int[] nums) {
        int answer = nums.length / 2;

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        if (set.size() >= answer) {
            return answer;
        }

        return set.size();
    }


    public static void main(String[] args) {

        Programmers52 test = new Programmers52();
        System.out.println(test.solution(new int[]{3, 1, 2, 3}));
        //System.out.println(Arrays.toString(test.solution(new int[]{1, 2, 2, 2, 3, 3, 3, 4, 5})));
    }
}
