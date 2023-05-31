import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers20 {

    public String solution(String X, String Y) {

        StringBuilder sb = new StringBuilder();

        int[] arr1 = new int[10];
        int[] arr2 = new int[10];

        for (int i = 0; i < X.length(); i++) {
            arr1[Integer.parseInt(String.valueOf(X.charAt(i)))] += 1;
        }

        for (int i = 0; i < Y.length(); i++) {
            arr2[Integer.parseInt(String.valueOf(Y.charAt(i)))] += 1;
        }

        for (int i = 9; i >= 0; i--) {
            while (arr1[i] > 0 && arr2[i] > 0) {
                sb.append(i);
                arr1[i] -= 1;
                arr2[i] -= 1;
            }
        }

        String answer = "";

        if ("".equals(sb.toString())) {
            answer = "-1";
        } else if ("0".equals(sb.substring(0, 1))) {
            answer = "0";
        } else {
            answer = sb.toString();
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers20 test = new Programmers20();
        System.out.println(test.solution("100", "2345"));
        System.out.println(test.solution("100", "203045"));
        System.out.println(test.solution("100", "123450"));
        System.out.println(test.solution("12321", "42531"));
        System.out.println(test.solution("5525", "1255"));
    }
}
