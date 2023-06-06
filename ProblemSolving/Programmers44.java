import java.util.Arrays;

public class Programmers44 {
    public int[] solution(long n) {
        StringBuilder temp = new StringBuilder(String.valueOf(n));
        temp.reverse();

        String[] tempAns = temp.toString().split("");

        int[] answer = new int[tempAns.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(tempAns[i]);
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers44 test = new Programmers44();
        System.out.println(test.solution(6));
        System.out.println(test.solution(16));
        System.out.println(test.solution(626331));
    }
}
