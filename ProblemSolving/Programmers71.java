import java.util.*;

public class Programmers71 {
    public int solution(int n, int k, int[] enemy) {

        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        int answer = 0;

        for (int i : enemy) {
            max.add(i);
            n -= i;
            if (n < 0) {
                if (k == 0) {
                    break;
                } else if (k >= 1) {
                    int temp = max.remove();
                    n += temp;
                    k--;
                    answer++;
                }
            } else if (n >= 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers71 test = new Programmers71();
        System.out.println(test.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));


        System.out.println(test.solution(2, 4, new int[]{3, 3, 3, 3}));


        System.out.println(test.solution(7, 3, new int[]{5, 5, 5, 5, 2, 3, 1}));//5
        System.out.println(test.solution(1, 6, new int[]{2, 2, 2, 2, 3, 3, 1}));//7
        System.out.println(test.solution(10, 1, new int[]{2, 2, 2, 2, 2, 10}));//6
        System.out.println(test.solution(10, 1, new int[]{2, 2, 2, 2, 10}));//5


    }
}
