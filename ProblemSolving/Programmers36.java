import java.util.Arrays;

public class Programmers36 {

    public int solution(int[] d, int budget) {
        int answer = 0;
        int nowBudget = 0;

        Arrays.sort(d);
        for (int i : d) {
            if (nowBudget + i > budget) {
                break;
            } else {
                answer += 1;
                nowBudget += i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers36 test = new Programmers36();
        System.out.println(test.solution(new int[]{1, 3, 2, 5, 4}, 9));
    }
}
