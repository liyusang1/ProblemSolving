import java.util.Arrays;

public class Programmers107 {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            answer[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(answer);
        return answer[0] + " " + answer[answer.length - 1];
    }

    public static void main(String[] args) {
        Programmers107 test = new Programmers107();
        System.out.println(test.solution("-1 -2 -3 -4"));
    }
}

